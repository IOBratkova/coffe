package ru.coffee.service.authorization.jwt;

import io.jsonwebtoken.Claims;

public interface JwtProviderService {

    String generateAccessToken(String username);

    String generateRefreshToken(String username);

    Claims getAccessClaims(String token);

    Claims getRefreshClaims(String token);

    boolean validateAccessToken(String accessToken);

    boolean validateRefreshToken(String refreshToken);
}

