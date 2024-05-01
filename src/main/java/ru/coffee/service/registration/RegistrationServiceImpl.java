package ru.coffee.service.registration;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.coffee.entity.User;
import ru.coffee.entity.UserCredential;
import ru.coffee.exceptions.registration.EmailIsAlreadyExistsException;
import ru.coffee.exceptions.registration.UsernameIsAlreadyExistsException;
import ru.coffee.repository.UserCredentialRepository;
import ru.coffee.repository.UserRepository;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private PasswordEncoder passwordEncoder;
    private UserCredentialRepository credentialRepository;
    private UserRepository userRepository;

    @Override
    public Long registration(UserCredential userCredential) throws EmailIsAlreadyExistsException, UsernameIsAlreadyExistsException {
        if (credentialRepository.existsByEmail(userCredential.getEmail())) {
            throw new EmailIsAlreadyExistsException("Пользователь с указанным email уже существует");
        }
        if (credentialRepository.existsByUsername(userCredential.getUsername())) {
            throw new UsernameIsAlreadyExistsException("Пользователь с указанным username уже существует");
        }
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        User user = new User(null, null, null, "-", "-", "-", userCredential);
        userRepository.save(user);
        return credentialRepository.save(userCredential).getId();
    }

}
