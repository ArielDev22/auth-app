package com.arieldev22.auth_app.auth.exceptions;

public class EmailAlreadyUsedException extends RuntimeException {
    public EmailAlreadyUsedException(String message) {
        super(message);
    }
}
