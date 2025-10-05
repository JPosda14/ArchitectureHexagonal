package co.com.bancolombia.model.todo.queries;

import co.com.credilya.todo.model.todo.TodoStatus;
import java.util.Optional;

public class ListTodosQuery {
    private final Optional<TodoStatus> status;

    public ListTodosQuery(Optional<TodoStatus> status) {
        this.status = status;
    }

    public Optional<TodoStatus> getStatus() {
        return status;
    }
}
