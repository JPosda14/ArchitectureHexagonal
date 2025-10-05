package co.com.bancolombia.infrastructure.entrypoints.rest.todo.dtos;

public record UpdateTodoRequest(Long id, String title, String description, String status) { }
