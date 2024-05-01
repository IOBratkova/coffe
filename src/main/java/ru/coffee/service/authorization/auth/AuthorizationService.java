package ru.coffee.service.authorization.auth;

import ru.coffee.exceptions.authorization.CredentialsIsNotExistsException;
import ru.coffee.exceptions.authorization.IncorrectPasswordException;
import ru.coffee.exceptions.user.UserWithEmailNotFound;
import ru.coffee.exceptions.user.UserWithUsernameNotFound;
import ru.coffee.rest.dto.TokenResponse;

public interface AuthorizationService {

    TokenResponse authorizeByEmail(String cred, String password) throws CredentialsIsNotExistsException, IncorrectPasswordException, UserWithUsernameNotFound, UserWithEmailNotFound;

    TokenResponse authorizeByUsername(String cred, String password) throws CredentialsIsNotExistsException, IncorrectPasswordException, UserWithUsernameNotFound, UserWithEmailNotFound;

}
