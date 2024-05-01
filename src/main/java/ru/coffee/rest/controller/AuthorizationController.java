package ru.coffee.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.exceptions.authorization.CredentialsIsNotExistsException;
import ru.coffee.exceptions.authorization.IncorrectPasswordException;
import ru.coffee.exceptions.user.UserWithEmailNotFound;
import ru.coffee.exceptions.user.UserWithUsernameNotFound;
import ru.coffee.rest.dto.EmailAuthorizationRequest;
import ru.coffee.rest.dto.TokenResponse;
import ru.coffee.rest.dto.UsernameAuthorizationRequest;
import ru.coffee.service.authorization.auth.AuthorizationService;

@RestController
@RequestMapping("v1/authorization")
@AllArgsConstructor
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @GetMapping("/email")
    TokenResponse authorizeByEmail(@RequestBody EmailAuthorizationRequest request) throws CredentialsIsNotExistsException, IncorrectPasswordException, UserWithEmailNotFound, UserWithUsernameNotFound {
        return authorizationService.authorizeByEmail(request.getEmail(), request.getPassword());
    }

    @GetMapping("/username")
    TokenResponse authorizeByUsername(@RequestBody UsernameAuthorizationRequest request) throws CredentialsIsNotExistsException, IncorrectPasswordException, UserWithEmailNotFound, UserWithUsernameNotFound {
        return authorizationService.authorizeByUsername(request.getUsername(), request.getPassword());
    }

}
