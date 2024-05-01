package ru.coffee.service.authorization.details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {

    ADMIN("ADMIN"),
    USER("USER");

    private final String vale;

    @Override
    public String getAuthority() {
        return vale;
    }

    public static Role getRole(String name) {
        for (Role r : values()) {
            if (Objects.equals(r.vale, name)) return r;
        }
        return null;
    }

}