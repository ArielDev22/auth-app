package com.arieldev22.auth_backend.services;

import com.arieldev22.auth_backend.exceptions.TokenException;
import com.arieldev22.auth_backend.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    @Autowired
    private RevokedTokenService revokedTokenService;

    // GERAR UM TOKEN PARA UM DETERMINADO USUARIO
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT
                    .create()
                    .withIssuer("auth-backend")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpirationToken())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new TokenException("Erro ao gerar o token de autenticação: ");
        }
    }

    // VALIDAR O TOKEN
    public String validateToken(String token) {
        try {
            if (revokedTokenService.isRevoked(token)) return null;

            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT
                    .require(algorithm)
                    .withIssuer("auth-backend")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            System.out.printf("Falha ao validar o token: " + e.getMessage());
            return null;
        }
    }

    private Instant generateExpirationToken() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
