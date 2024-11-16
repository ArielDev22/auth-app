package com.arieldev22.auth_backend.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
    USER("user"),
    ADMIN("admin");

    private String value;

    public static UserRole getRoleOf(String role) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.getValue().equalsIgnoreCase(role)) return userRole;
        }
        return null;
    }
}
