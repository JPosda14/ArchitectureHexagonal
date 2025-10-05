package co.com.bancolombia.infrastructure.drivenadapters.jparepository.repositories;

import co.com.bancolombia.model.todo.Todo;
import co.com.bancolombia.model.todo.TodoStatus;
import co.com.bancolombia.model.todo.gateways.TodoRepository;
import co.com.bancolombia.model.todo.exceptions.TodoAlreadyExistsException;
import co.com.bancolombia.model.todo.exceptions.TodoNotFoundException;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryTodoRepository implements TodoRepository {

    private final Map<Long, Todo> todos = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Todo save(Todo todo) {
        boolean exists = todos.values().stream()
                .anyMatch(t -> t.getTitle().equalsIgnoreCase(todo.getTitle()));

        if (exists) {
            throw new TodoAlreadyExistsException(todo.getTitle());
        }

        Long id = idGenerator.getAndIncrement();
        Todo newTodo = new Todo(
                id,
                todo.getTitle(),
                todo.getDescription(),
                TodoStatus.PENDING,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        todos.put(id, newTodo);
        return newTodo;
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return Optional.ofNullable(todos.get(id));
    }

    @Override
    public List<Todo> listAll() {
        return new ArrayList<>(todos.values());
    }

    @Override
    public Todo update(Todo todo) {
        if (!todos.containsKey(todo.getId())) {
            throw new TodoNotFoundException(todo.getId());
        }
        todos.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public void delete(Long id) {
        if (!todos.containsKey(id)) {
            throw new TodoNotFoundException(id);
        }
        todos.remove(id);
    }
}
