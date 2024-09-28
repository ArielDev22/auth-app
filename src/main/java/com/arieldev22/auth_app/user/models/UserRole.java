package com.arieldev22.auth_app.user.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    public static UserRole roleOf(String role) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.getRole().equals(role)) {
                return userRole;
            }
        }
        return null;
    }
}
