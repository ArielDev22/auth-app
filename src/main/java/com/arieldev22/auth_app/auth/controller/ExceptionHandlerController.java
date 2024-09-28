package com.arieldev22.auth_app.auth.controller;

import com.arieldev22.auth_app.auth.dto.ExceptionMessageDTO;
import com.arieldev22.auth_app.auth.exceptions.EmailAlreadyUsedException;
import com.arieldev22.auth_app.auth.exceptions.IncorrectPasswordException;
import com.arieldev22.auth_app.auth.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(EmailAlreadyUsedException.class)
    private ResponseEntity<ExceptionMessageDTO> emailAlreadyUsed(EmailAlreadyUsedException exception) {
        ExceptionMessageDTO messageDTO = new ExceptionMessageDTO(HttpStatus.BAD_REQUEST, exception.getMessage());

        return ResponseEntity.badRequest().body(messageDTO);
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    private ResponseEntity<ExceptionMessageDTO> incorrectPassword(IncorrectPasswordException exception) {
        ExceptionMessageDTO messageDTO = new ExceptionMessageDTO(HttpStatus.BAD_REQUEST, exception.getMessage());

        return ResponseEntity.badRequest().body(messageDTO);
    }

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<ExceptionMessageDTO> userNotFound(UserNotFoundException exception) {
        ExceptionMessageDTO messageDTO = new ExceptionMessageDTO(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageDTO);

    }
}
