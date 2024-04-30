package ru.coffee.rest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.exceptions.registration.EmailIsAlreadyExistsException;
import ru.coffee.exceptions.registration.UsernamelIsAlreadyExistsException;
import ru.coffee.rest.dto.RegistrationDto;
import ru.coffee.rest.mapper.RegistrationMapper;
import ru.coffee.service.RegistrationService;

@RestController
@RequestMapping("v1/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    private final RegistrationMapper registrationMapper;

    public RegistrationController(RegistrationService registrationService, RegistrationMapper registrationMapper) {
        this.registrationService = registrationService;
        this.registrationMapper = registrationMapper;
    }


    @PostMapping
    Long registration(@RequestBody RegistrationDto registration) throws UsernamelIsAlreadyExistsException, EmailIsAlreadyExistsException {
        return registrationService.registration(registrationMapper.toEntity(registration));
    }

}
