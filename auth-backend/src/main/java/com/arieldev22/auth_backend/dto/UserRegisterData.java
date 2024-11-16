package com.arieldev22.auth_backend.dto;

import com.arieldev22.auth_backend.model.User;

public record UserRegisterData(String email, String name, String password, String role) {
    public User toModel() {
        return new User(email, name, password, role);
    }
}
