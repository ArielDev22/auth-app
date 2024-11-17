package com.arieldev22.auth_backend.controller;

import com.arieldev22.auth_backend.dto.HandlerMessage;
import com.arieldev22.auth_backend.exceptions.AlreadyUsedEmailException;
import com.arieldev22.auth_backend.exceptions.InvalidCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerController {
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<HandlerMessage> invalidCredentials(InvalidCredentialsException exception){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new HandlerMessage(exception.getMessage()));
    }

    @ExceptionHandler(AlreadyUsedEmailException.class)
    public ResponseEntity<HandlerMessage> alreadyUsedEmail(AlreadyUsedEmailException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new HandlerMessage(exception.getMessage()));
    }
}
