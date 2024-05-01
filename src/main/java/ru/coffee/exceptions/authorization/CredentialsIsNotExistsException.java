package ru.coffee.exceptions.authorization;

//@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Не переданы параметры для входа")
public class CredentialsIsNotExistsException extends Exception {
    public CredentialsIsNotExistsException(String message) {
        super(message);
    }
}
