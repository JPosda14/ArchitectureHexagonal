package co.com.bancolombia.model.todo.results;

public class TodoDeletedResult {
    private final Long id;
    private final String message;

    public TodoDeletedResult(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
