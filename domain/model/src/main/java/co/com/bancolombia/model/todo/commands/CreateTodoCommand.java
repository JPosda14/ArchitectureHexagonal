package co.com.bancolombia.model.todo.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateTodoCommand {
    private final String title;
    private final String description;
}
