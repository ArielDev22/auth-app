package com.arieldev22.auth_backend.services;

import com.arieldev22.auth_backend.dto.UserLoginData;
import com.arieldev22.auth_backend.exceptions.InvalidCredentialsException;
import com.arieldev22.auth_backend.model.User;
import com.arieldev22.auth_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder encoder;

    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new InvalidCredentialsException("Já existe uma conta com este email");
        }

        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

    public User login(UserLoginData data) {
        User user = (User) userRepository.findByEmail(data.email());

        if (user == null) {
            throw new InvalidCredentialsException("Não existe uma conta com este email");
        }

        if (!encoder.matches(data.password(), user.getPassword())) {
            throw new InvalidCredentialsException("Senha incorreta");
        }

        return user;
    }
}
