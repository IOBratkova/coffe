package ru.coffee.exceptions.registration;

//@ResponseStatus(code = HttpStatus., "")
public class EmailIsAlreadyExistsException extends Exception {
    public EmailIsAlreadyExistsException(String message) {
        super(message);
    }
}
