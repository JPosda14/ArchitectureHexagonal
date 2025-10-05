package co.com.bancolombia.model.todo.exceptions;

import co.com.credilya.todo.model.todo.constants.ExceptionMessages;

public class TodoAlreadyExistsException extends RuntimeException {
    public TodoAlreadyExistsException(String title) {
        super(String.format(ExceptionMessages.TODO_ALREADY_EXISTS.getMessage(), title));
    }
}
