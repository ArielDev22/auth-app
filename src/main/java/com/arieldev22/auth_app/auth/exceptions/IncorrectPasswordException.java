package com.arieldev22.auth_app.auth.exceptions;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(String message) {
        super(message);
    }
}
