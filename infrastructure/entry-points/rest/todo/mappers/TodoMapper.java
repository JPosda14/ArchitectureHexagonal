package co.com.bancolombia.infrastructure.entrypoints.rest.todo.mappers;

import co.com.bancolombia.infrastructure.entrypoints.rest.todo.dtos.*;
import co.com.bancolombia.model.todo.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    @Mapping(target = "id", ignore = true)
    Todo toDomain(CreateTodoRequest request);

    TodoResponse toResponse(Todo todo);

    List<TodoResponse> toResponseList(List<Todo> todos);
}
