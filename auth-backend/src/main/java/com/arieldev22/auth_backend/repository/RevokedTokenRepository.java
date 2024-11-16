package com.arieldev22.auth_backend.repository;

import com.arieldev22.auth_backend.model.RevokedToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevokedTokenRepository extends JpaRepository<RevokedToken, Long> {
}
