package co.com.bancolombia.usecase.todo;

import java.time.LocalDateTime;
import co.com.bancolombia.model.todo.Todo;
import co.com.bancolombia.model.todo.TodoStatus;
import co.com.bancolombia.model.todo.commands.UpdateTodoCommand;
import co.com.bancolombia.model.todo.exceptions.TodoNotFoundException;
import co.com.bancolombia.model.todo.results.UpdateTodoResult;
import co.com.bancolombia.model.todo.gateways.TodoRepository;

public class UpdateTodoUseCase {

    private final TodoRepository todoRepository;

    public UpdateTodoUseCase(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public UpdateTodoResult execute(UpdateTodoCommand command) {
        Todo existingTodo = todoRepository.findById(command.getId())
                .orElseThrow(() -> new TodoNotFoundException(command.getId()));

        if (command.getStatus() == null) {
            throw new IllegalArgumentException("Todo status cannot be null");
        }

        Todo updatedTodo = new Todo(
                existingTodo.getId(),
                command.getTitle() != null ? command.getTitle() : existingTodo.getTitle(),
                command.getDescription() != null ? command.getDescription() : existingTodo.getDescription(),
                command.getStatus(),
                existingTodo.getCreatedAt(),
                LocalDateTime.now()
        );

        todoRepository.update(updatedTodo);
        return new UpdateTodoResult(updatedTodo);
    }
}
