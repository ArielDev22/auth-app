package com.arieldev22.auth_app.database.config;

import com.arieldev22.auth_app.user.models.User;
import com.arieldev22.auth_app.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class dbConfig {
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User("Carlos", "carlos@gmail.com", "1234", "user"));
            userRepository.save(new User("Maria", "maria@gmail.com", "1234", "user"));
            userRepository.save(new User("Pedro", "pedro@gmail.com", "1234", "user"));

            userRepository.save(new User("Sarah", "sarah@gmail.com", "1234", "admin"));
        };
    }
}
