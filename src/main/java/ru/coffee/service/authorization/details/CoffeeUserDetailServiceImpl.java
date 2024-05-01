package ru.coffee.service.authorization.details;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffee.entity.UserCredential;
import ru.coffee.exceptions.user.CoffeeRoleNotFoundException;
import ru.coffee.repository.UserCredentialRepository;

import java.util.Set;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeUserDetailServiceImpl implements CoffeeUserDetailService {

    private UserCredentialRepository credentialRepository;

    @Override
    public UserPrincipal loadByUsername(String username) throws CoffeeRoleNotFoundException {
        UserCredential user = credentialRepository.findByUsername(username).orElse(null);
        if (user == null) {
            throw new NullPointerException();
        }
        Role role = Role.getRole(user.getRole());
        if (role == null) {
            throw new CoffeeRoleNotFoundException(user.getRole());
        }
        return new UserPrincipal(username, user.getPassword(), Set.of(role));
    }
}
