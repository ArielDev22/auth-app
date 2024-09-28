package com.arieldev22.auth_app.auth.exceptions;

public class TokenException extends RuntimeException {
    public TokenException(String message) {
        super("Failure to generate token: " + message);
    }
}
