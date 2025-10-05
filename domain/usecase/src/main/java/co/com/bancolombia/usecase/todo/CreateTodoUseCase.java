package co.com.bancolombia.usecase.todo;

import co.com.bancolombia.model.todo.Todo;
import co.com.bancolombia.model.todo.commands.CreateTodoCommand;
import co.com.bancolombia.model.todo.constants.TodoConstants;
import co.com.bancolombia.model.todo.exceptions.TodoAlreadyExistsException;
import co.com.bancolombia.model.todo.gateways.TodoRepository;
import co.com.bancolombia.model.todo.TodoStatus;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class CreateTodoUseCase {

    private final TodoRepository todoRepository;

    public Todo execute(CreateTodoCommand command) {

        if (command.getTitle().length() > TodoConstants.MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException("El título supera la longitud máxima permitida");
        }


        if (command.getDescription() != null &&
                command.getDescription().length() > TodoConstants.MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("La descripción supera la longitud máxima permitida");
        }

        todoRepository.findByTitle(command.getTitle())
                .ifPresent(todo -> {
                    throw new TodoAlreadyExistsException(command.getTitle());
                });

        Todo todo = Todo.builder()
                .title(command.getTitle())
                .description(command.getDescription())
                .status(TodoStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return todoRepository.save(todo);
    }
}
