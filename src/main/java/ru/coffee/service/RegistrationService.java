package ru.coffee.service;

import ru.coffee.entity.UserCredential;
import ru.coffee.exceptions.registration.EmailIsAlreadyExistsException;
import ru.coffee.exceptions.registration.UsernamelIsAlreadyExistsException;

public interface RegistrationService {

    Long registration(UserCredential userCredential) throws EmailIsAlreadyExistsException, UsernamelIsAlreadyExistsException;

}
