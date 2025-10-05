package co.com.bancolombia.drivenadapters.jparepository;

import co.com.bancolombia.model.todo.Todo;
import co.com.bancolombia.model.todo.TodoStatus;
import co.com.bancolombia.model.todo.gateways.TodoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    private final Map<Long, Todo> todos = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Todo save(Todo todo) {
        Long id = (todo.getId() == null) ? idGenerator.getAndIncrement() : todo.getId();
        Todo savedTodo = new Todo(
                id,
                todo.getTitle(),
                todo.getDescription(),
                todo.getStatus() == null ? TodoStatus.PENDING : todo.getStatus(),
                todo.getCreatedAt() != null ? todo.getCreatedAt() : LocalDateTime.now(),
                LocalDateTime.now()
        );
        todos.put(id, savedTodo);
        return savedTodo;
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return Optional.ofNullable(todos.get(id));
    }

    @Override
    public Optional<Todo> findByTitle(String title) {
        return todos.values().stream()
                .filter(todo -> todo.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(todos.values());
    }

    @Override
    public void deleteById(Long id) {
        todos.remove(id);
    }
}
