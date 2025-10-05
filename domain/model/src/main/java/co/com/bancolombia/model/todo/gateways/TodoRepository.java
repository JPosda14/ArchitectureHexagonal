package co.com.bancolombia.model.todo.gateways;

import co.com.bancolombia.model.todo.Todo;
import java.util.List;
import java.util.Optional;

public interface TodoRepository {


    Todo create(Todo todo);

    Todo update(Todo todo);

    void delete(String id);

    Optional<Todo> getById(String id);

    List<Todo> listAll();
}
