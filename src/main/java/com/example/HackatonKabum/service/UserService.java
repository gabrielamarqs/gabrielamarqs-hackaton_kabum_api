package com.example.HackatonKabum.service;

import com.example.HackatonKabum.model.User;
import com.example.HackatonKabum.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User signUp (User input) throws Exception {
        if (userRepository.findByEmail(input.getEmail()) != null) {
            throw new Exception("Email already registered");
        }
        if (userRepository.findByUsername(input.getUsername()) != null) {
            throw new Exception("Username already registered");
        }
        User user = new User();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setGender(input.getGender());
        user.setPassword(input.getPassword());
        user.setUsername(input.getUsername());
        user.setRole(input.getRole());
        return userRepository.save(user);
    }

    public User login(User loginDTO) throws LoginException {
        User userEmail = userRepository.findByEmail(loginDTO.getEmail());
        User userPassword = userRepository.findByPassword(loginDTO.getPassword());
        if (userEmail == null || userPassword == null) {
            throw new LoginException("Invalid email or password");
        } else {
            return userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        }
    }
}
