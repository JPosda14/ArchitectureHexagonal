package co.com.bancolombia.model.todo.results;

import co.com.bancolombia.model.todo.Todo;

public class UpdateTodoResult {
    private final Todo updatedTodo;

    public UpdateTodoResult(Todo updatedTodo) {
        this.updatedTodo = updatedTodo;
    }

    public Todo getUpdatedTodo() {
        return updatedTodo;
    }
}
