package com.arieldev22.auth_app.user.repository;

import com.arieldev22.auth_app.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
