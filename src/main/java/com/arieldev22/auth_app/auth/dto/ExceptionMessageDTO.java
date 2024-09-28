package com.arieldev22.auth_app.auth.dto;

import org.springframework.http.HttpStatus;

public record ExceptionMessageDTO(HttpStatus status, String message) {
}
