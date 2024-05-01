package ru.coffee.exceptions.user;

public class CoffeeRoleNotFoundException extends Exception {
    public CoffeeRoleNotFoundException(String role) {
        super(String.format("Роли %s не существует", role));
    }
}
