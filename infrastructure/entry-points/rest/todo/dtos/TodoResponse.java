package co.com.bancolombia.infrastructure.entrypoints.rest.todo.dtos;

public record TodoResponse(Long id, String title, String description, String status) { }
