package co.com.bancolombia.usecase.todo;

import co.com.bancolombia.model.todo.Todo;
import co.com.bancolombia.model.todo.gateways.TodoRepository;
import co.com.bancolombia.model.todo.results.ListTodosResult;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListTodosUseCase {

    private final TodoRepository todoRepository;

    public ListTodosResult execute() {
        List<Todo> todos = todoRepository.listAll();
        return new ListTodosResult(todos);
    }
}
