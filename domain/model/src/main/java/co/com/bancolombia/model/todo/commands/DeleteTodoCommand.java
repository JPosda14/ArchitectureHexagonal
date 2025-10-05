package co.com.bancolombia.model.todo.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DeleteTodoCommand {
    private final Long id;
}
