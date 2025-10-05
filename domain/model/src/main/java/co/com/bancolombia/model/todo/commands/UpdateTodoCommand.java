package co.com.bancolombia.model.todo.commands;

import co.com.bancolombia.model.todo.TodoStatus;

public class UpdateTodoCommand {
    private final Long id;
    private final String title;
    private final String description;
    private final TodoStatus status;

    public UpdateTodoCommand(Long id, String title, String description, TodoStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TodoStatus getStatus() {
        return status;
    }
}
