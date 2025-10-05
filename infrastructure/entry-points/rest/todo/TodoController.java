package co.com.bancolombia.infrastructure.entrypoints.rest.todo;

import co.com.bancolombia.infrastructure.entrypoints.rest.todo.dtos.*;
import co.com.bancolombia.infrastructure.entrypoints.rest.todo.mappers.TodoMapper;
import co.com.bancolombia.model.todo.Todo;
import co.com.bancolombia.usecase.todo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final CreateTodoUseCase createTodoUseCase;
    private final GetTodoByIdUseCase getTodoByIdUseCase;
    private final UpdateTodoUseCase updateTodoUseCase;
    private final DeleteTodoUseCase deleteTodoUseCase;
    private final ListTodosUseCase listTodosUseCase;
    private final TodoMapper mapper;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody CreateTodoRequest request) {
        Todo todo = createTodoUseCase.execute(mapper.toDomain(request));
        return ResponseEntity.ok(mapper.toResponse(todo));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> list() {
        List<Todo> todos = listTodosUseCase.execute().todos();
        return ResponseEntity.ok(mapper.toResponseList(todos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getById(@PathVariable Long id) {
        Todo todo = getTodoByIdUseCase.execute(id);
        return ResponseEntity.ok(mapper.toResponse(todo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody UpdateTodoRequest request) {
        Todo todo = updateTodoUseCase.execute(id, request.title(), request.description(), request.status());
        return ResponseEntity.ok(mapper.toResponse(todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteTodoUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
