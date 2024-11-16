package com.arieldev22.auth_backend.repository;

import com.arieldev22.auth_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
