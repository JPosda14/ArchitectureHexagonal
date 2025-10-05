package co.com.bancolombia.usecase.todo;

import com.tuempresa.todo.domain.entities.Todo;
import com.tuempresa.todo.domain.repositories.TodoRepository;

public class DeleteTodoUseCase {
    private final TodoRepository todoRepository;

    public DeleteTodoUseCase(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public boolean execute(Long id) {
        Todo todo = todoRepository.findById(id);
        if (todo == null) {
            return false;
        }
        todoRepository.delete(id);
        return true;
    }
}
