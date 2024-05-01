package ru.coffee.exceptions.user;

public class UserWithEmailNotFound extends Exception {
    public UserWithEmailNotFound(String username) {
        super(String.format("Пользователь с %s не найден", username));
    }
}
