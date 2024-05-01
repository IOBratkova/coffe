package ru.coffee.service.authorization.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPrincipal {

    private String username;
    private String password;
    private Set<Role> roles;

}
