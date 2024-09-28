package com.arieldev22.auth_app.auth.controller;

import com.arieldev22.auth_app.auth.dto.AuthResponseDTO;
import com.arieldev22.auth_app.auth.dto.LoginRequestDTO;
import com.arieldev22.auth_app.auth.dto.RegisterRequestDTO;
import com.arieldev22.auth_app.auth.exceptions.EmailAlreadyUsedException;
import com.arieldev22.auth_app.auth.exceptions.IncorrectPasswordException;
import com.arieldev22.auth_app.auth.exceptions.UserNotFoundException;
import com.arieldev22.auth_app.auth.service.TokenService;
import com.arieldev22.auth_app.user.models.User;
import com.arieldev22.auth_app.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder encoder;

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO body) {
        User user = (User) userRepository.findByEmail(body.email());

        if (user != null) {
            if (encoder.matches(body.password(), user.getPassword())) {
                String token = tokenService.generateToken(user);

                return ResponseEntity.ok(new AuthResponseDTO(token));
            } else {
                throw new IncorrectPasswordException("incorrect password");
            }
        } else {
            throw new UserNotFoundException("An account with this email doesn't exist");
        }
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        User user = (User) userRepository.findByEmail(body.email());

        if (user == null){
            String encodedPassword = encoder.encode(body.password());

            User newUser = new User(body.name(), body.email(), encodedPassword, body.role());

            userRepository.save(newUser);

            return ResponseEntity.ok().build();
        } else {
            throw new EmailAlreadyUsedException("An account with this email already exists");
        }
    }
}
