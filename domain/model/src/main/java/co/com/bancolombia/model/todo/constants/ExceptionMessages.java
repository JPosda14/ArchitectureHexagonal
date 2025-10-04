package co.com.credilya.todo.domain.model.todo.constants;

public enum ExceptionMessages {
    TODO_ALREADY_EXISTS("Todo with title '%s' already exists"),
    TODO_NOT_FOUND("Todo with id '%s' not found");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
