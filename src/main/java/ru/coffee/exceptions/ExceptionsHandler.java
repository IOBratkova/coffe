package ru.coffee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.coffee.exceptions.registration.EmailIsAlreadyExistsException;
import ru.coffee.exceptions.registration.UsernameIsAlreadyExistsException;

import java.util.Date;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({EmailIsAlreadyExistsException.class, UsernameIsAlreadyExistsException.class})
    ResponseEntity<CoffeeException> handleEx(Exception e) {
        CoffeeException coffee = new CoffeeException(new Date(), e.getMessage());
        return new ResponseEntity<>(coffee, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
