package co.com.bancolombia.model.todo.results;

import co.com.credilya.todo.model.todo.Todo;

public class TodoResult {
    private final Todo todo;

    public TodoResult(Todo todo) {
        this.todo = todo;
    }

    public Todo getTodo() {
        return todo;
    }
}
