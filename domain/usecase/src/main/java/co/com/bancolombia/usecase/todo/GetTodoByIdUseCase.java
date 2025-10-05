package co.com.bancolombia.usecase;

import co.com.bancolombia.model.todo.Todo;
import co.com.bancolombia.model.todo.gateways.TodoRepository;
import co.com.bancolombia.model.todo.queries.GetTodoByIdQuery;
import co.com.bancolombia.model.todo.results.GetTodoByIdResult;
import co.com.bancolombia.model.todo.exceptions.TodoNotFoundException;

public class GetTodoByIdUseCase {

    private final TodoRepository todoRepository;

    public GetTodoByIdUseCase(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public GetTodoByIdResult execute(GetTodoByIdQuery query) {
        Todo todo = todoRepository.findById(query.getId())
                .orElseThrow(() -> new TodoNotFoundException(query.getId()));

        return new GetTodoByIdResult(todo);
    }
}
