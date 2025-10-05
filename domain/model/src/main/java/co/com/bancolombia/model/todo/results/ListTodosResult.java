package co.com.credilya.todo.model.todo.results;

import co.com.credilya.todo.model.todo.Todo;
import java.util.List;

public class ListTodosResult {
    private final List<Todo> todos;

    public ListTodosResult(List<Todo> todos) {
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }
}
