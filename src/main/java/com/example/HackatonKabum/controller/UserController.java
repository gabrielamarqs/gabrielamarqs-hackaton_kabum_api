package com.example.HackatonKabum.controller;

import com.example.HackatonKabum.model.User;
import com.example.HackatonKabum.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;

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
    public ResponseEntity<User> register(@RequestBody User signUpDTO) throws Exception {
        User registeredUser = userService.signUp(signUpDTO);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginDTO) throws LoginException {
        User loggedUser = userService.login(loginDTO);
        return ResponseEntity.ok("User " + loggedUser.getUsername() + " logged in");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody User loginDTO) throws LoginException {
        User loggedUser = userService.login(loginDTO);
        return ResponseEntity.ok("User " + loggedUser.getUsername() + " logged in");
    }

}
