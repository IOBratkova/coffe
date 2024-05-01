package ru.coffee.exceptions.registration;

//@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Пользователь с указанным username уже существует")
public class UsernameIsAlreadyExistsException extends Exception {
    public UsernameIsAlreadyExistsException(String message) {
        super(message);
    }
}
