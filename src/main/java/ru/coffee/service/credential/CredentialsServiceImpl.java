package ru.coffee.service.credential;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffee.entity.UserCredential;
import ru.coffee.exceptions.user.UserWithEmailNotFound;
import ru.coffee.exceptions.user.UserWithUsernameNotFound;
import ru.coffee.repository.UserCredentialRepository;

@Service
@AllArgsConstructor
public class CredentialsServiceImpl implements CredentialsService {

    private UserCredentialRepository credentialRepository;

    @Override
    public UserCredential findByUsername(String username) throws UserWithUsernameNotFound {
        UserCredential userCredential = credentialRepository.findByUsername(username).orElse(null);
        if (userCredential == null) {
            throw new UserWithUsernameNotFound(username);
        }
        return userCredential;
    }

    @Override
    public UserCredential findByEmail(String email) throws UserWithEmailNotFound {
        UserCredential userCredential = credentialRepository.findByEmail(email).orElse(null);
        if (userCredential == null) {
            throw new UserWithEmailNotFound(email);
        }
        return userCredential;
    }
}
