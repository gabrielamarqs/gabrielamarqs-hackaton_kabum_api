package com.example.HackatonKabum.controller;

import com.example.HackatonKabum.model.User;
import com.example.HackatonKabum.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() throws Exception {
        return ResponseEntity.ok("hello world");
    }

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody User signUp) throws Exception {
        String registeredUser = userService.signUp(signUp);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User login) throws LoginException {
        String loggedUser = userService.login(login);
        return ResponseEntity.ok(loggedUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable UUID id, @RequestBody User userUpdate) throws LoginException {
        String updatedUser = userService.updateUser(id, userUpdate);
        return ResponseEntity.ok("User " + updatedUser + " updated successfully.");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) throws LoginException {
        User user = userService.getUserId(id);
        return ResponseEntity.ok(user);
    }

}
