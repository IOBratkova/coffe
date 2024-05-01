package ru.coffee.service.authorization.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.coffee.entity.UserCredential;
import ru.coffee.exceptions.authorization.IncorrectPasswordException;
import ru.coffee.exceptions.user.UserWithEmailNotFound;
import ru.coffee.exceptions.user.UserWithUsernameNotFound;
import ru.coffee.rest.dto.TokenResponse;
import ru.coffee.service.authorization.jwt.JwtProviderService;
import ru.coffee.service.credential.CredentialsService;

@Service
@AllArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    private PasswordEncoder passwordEncoder;
    private CredentialsService credentialsService;
    private JwtProviderService jwtProviderService;

    @Override
    public TokenResponse authorizeByEmail(String cred, String password) throws IncorrectPasswordException, UserWithEmailNotFound {
        UserCredential userCredential = credentialsService.findByEmail(cred);
        if (!passwordEncoder.matches(password, userCredential.getPassword())) {
            throw new IncorrectPasswordException("Некорректный пароль");
        }
        return new TokenResponse(
                jwtProviderService.generateAccessToken(userCredential.getUsername()),
                jwtProviderService.generateRefreshToken(userCredential.getUsername())
        );
    }

    @Override
    public TokenResponse authorizeByUsername(String cred, String password) throws IncorrectPasswordException, UserWithUsernameNotFound {
        UserCredential userCredential = credentialsService.findByUsername(cred);
        if (!passwordEncoder.matches(password, userCredential.getPassword())) {
            throw new IncorrectPasswordException("Некорректный пароль");
        }
        return new TokenResponse(
                jwtProviderService.generateAccessToken(userCredential.getUsername()),
                jwtProviderService.generateRefreshToken(userCredential.getUsername())
        );
    }

}
