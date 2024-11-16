package com.arieldev22.auth_backend.services;

import com.arieldev22.auth_backend.model.RevokedToken;
import com.arieldev22.auth_backend.repository.RevokedTokenRepository;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class RevokedTokenService {
    @Autowired
    private RevokedTokenRepository revokedTokenRepository;

    public String revokeToken(String token) {
        revokedTokenRepository.save(new RevokedToken(token, extractExpirationDate(token)));

        return "Token revogado com suecesso";
    }

    public boolean isRevoked(String token) {
        return revokedTokenRepository.findByToken(token).isPresent();
    }

    private Instant extractExpirationDate(String token) {
        return JWT.decode(token).getExpiresAtAsInstant();
    }
}
