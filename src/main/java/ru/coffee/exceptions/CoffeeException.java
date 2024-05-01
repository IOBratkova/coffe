package ru.coffee.exceptions;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
public class CoffeeException implements Serializable {
    private Date date;
    private String message;
}
