package com.arieldev22.auth_backend.controller;

import com.arieldev22.auth_backend.dto.AuthResponse;
import com.arieldev22.auth_backend.dto.UserData;
import com.arieldev22.auth_backend.dto.UserLoginData;
import com.arieldev22.auth_backend.dto.UserRegisterData;
import com.arieldev22.auth_backend.model.User;
import com.arieldev22.auth_backend.services.TokenService;
import com.arieldev22.auth_backend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private UserService userService;
    private TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserRegisterData data) {
        User user = userService.registerUser(data.toModel());

        UserData userData = new UserData(user.getId(), user.getName(), user.getEmail(), null);

        AuthResponse response = new AuthResponse("sucesso", "Usuário registrado!", userData);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserLoginData data) {
        User user = userService.login(data);

        String token = tokenService.generateToken(user);

        UserData userData = new UserData(user.getId(), user.getName(), user.getEmail(), token);

        AuthResponse response = new AuthResponse("sucesso", "Login realizado com sucesso", userData);

        return ResponseEntity.ok(response);
    }
}
