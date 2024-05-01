package ru.coffee.exceptions.authorization;

public class IncorrectPasswordException extends Exception {

    public IncorrectPasswordException(String message) {
        super(message);
    }
}
