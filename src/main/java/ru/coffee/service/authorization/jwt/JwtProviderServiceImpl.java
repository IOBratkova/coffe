package ru.coffee.service.authorization.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtProviderServiceImpl implements JwtProviderService {

    private final SecretKey jwtSecret;

    public JwtProviderServiceImpl(@Value("${jwt.secret}") String jwtAccessSecret) {
        this.jwtSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtAccessSecret));
    }

    @Override
    public String generateAccessToken(String username) {
        LocalDateTime now = LocalDateTime.now();
        Instant accessExpirationInstant = now.plusMinutes(5).atZone(ZoneId.systemDefault()).toInstant();
        final Date accessExpiration = Date.from(accessExpirationInstant);
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(accessExpiration)
                .signWith(jwtSecret)
                .compact();
    }

    @Override
    public String generateRefreshToken(String username) {
        LocalDateTime now = LocalDateTime.now();
        Instant accessExpirationInstant = now.plusMinutes(30).atZone(ZoneId.systemDefault()).toInstant();
        final Date accessExpiration = Date.from(accessExpirationInstant);
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(accessExpiration)
                .signWith(jwtSecret)
                .compact();
    }

    @Override
    public boolean validateAccessToken(String accessToken) {
        return validateToken(accessToken, jwtSecret);
    }

    @Override
    public boolean validateRefreshToken(String refreshToken) {
        return validateToken(refreshToken, jwtSecret);
    }

    @Override
    public Claims getAccessClaims(String token) {
        return getClaims(token, jwtSecret);
    }

    @Override
    public Claims getRefreshClaims(String token) {
        return getClaims(token, jwtSecret);
    }

    private Claims getClaims( String token, Key secret) {
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean validateToken(String token, Key secret) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


