package ru.coffee.exceptions.user;

public class UserWithUsernameNotFound extends Exception {
    public UserWithUsernameNotFound(String email) {
        super(String.format("Пользователь с %s не найден", email));
    }
}
