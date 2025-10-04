package co.com.credilya.todo.domain.model.todo.exceptions;

import co.com.credilya.todo.domain.model.todo.constants.ExceptionMessages;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(Long id) {
        super(String.format(ExceptionMessages.TODO_NOT_FOUND.getMessage(), id));
    }
}
