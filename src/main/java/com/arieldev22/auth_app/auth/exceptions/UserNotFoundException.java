package com.arieldev22.auth_app.auth.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
