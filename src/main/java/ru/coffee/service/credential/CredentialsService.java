package ru.coffee.service.credential;

import ru.coffee.entity.UserCredential;
import ru.coffee.exceptions.user.UserWithEmailNotFound;
import ru.coffee.exceptions.user.UserWithUsernameNotFound;

public interface CredentialsService {

    UserCredential findByUsername(String username) throws UserWithUsernameNotFound;

    UserCredential findByEmail(String email) throws UserWithEmailNotFound;

}
