package ru.coffee.service.registration;

import ru.coffee.entity.UserCredential;
import ru.coffee.exceptions.registration.EmailIsAlreadyExistsException;
import ru.coffee.exceptions.registration.UsernameIsAlreadyExistsException;

public interface RegistrationService {

    Long registration(UserCredential userCredential) throws EmailIsAlreadyExistsException, UsernameIsAlreadyExistsException;

}
