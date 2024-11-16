package com.arieldev22.auth_backend.dto;

public record AuthResponse(String status, String message, UserData data) {
}
