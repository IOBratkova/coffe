package ru.coffee.exceptions.registration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Пользователь с указанным email уже существует")
public class EmailIsAlreadyExistsException extends Exception {

}
