package com.arieldev22.auth_app.user.controller;

import com.arieldev22.auth_app.user.models.User;
import com.arieldev22.auth_app.user.models.UserDTO;
import com.arieldev22.auth_app.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/info/{id}")
    public ResponseEntity<UserDTO> userInfo(@PathVariable(name = "id") Long id) {
        User user = userService.getUserById(id);
        UserDTO userDTO = new UserDTO(user.getName(), user.getEmail(), user.getRole().getRole());

        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
