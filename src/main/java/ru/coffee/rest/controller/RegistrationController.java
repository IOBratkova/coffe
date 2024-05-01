package ru.coffee.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.exceptions.registration.EmailIsAlreadyExistsException;
import ru.coffee.exceptions.registration.UsernameIsAlreadyExistsException;
import ru.coffee.rest.dto.IdResponse;
import ru.coffee.rest.dto.RegistrationRequest;
import ru.coffee.rest.mapper.RegistrationMapper;
import ru.coffee.service.registration.RegistrationService;

@RestController
@RequestMapping("v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    private final RegistrationMapper registrationMapper;

    @PostMapping
    IdResponse registration(@RequestBody RegistrationRequest registration) throws UsernameIsAlreadyExistsException, EmailIsAlreadyExistsException {
        return new IdResponse(registrationService.registration(registrationMapper.toEntity(registration)));
    }

}
