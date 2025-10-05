package co.com.bancolombia.model.todo.results;

import co.com.bancolombia.model.todo.Todo;

public class GetTodoByIdResult {
    private final Todo todo;

    public GetTodoByIdResult(Todo todo) {
        this.todo = todo;
    }

    public Todo getTodo() {
        return todo;
    }
}
