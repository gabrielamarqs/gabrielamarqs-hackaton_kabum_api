package com.example.HackatonKabum.service;

import com.example.HackatonKabum.model.User;
import com.example.HackatonKabum.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String signUp (User input) throws Exception {
        if (userRepository.findByEmail(input.getEmail()) != null) {
            return "Email já cadastrado";
        }
        if (userRepository.findByUsername(input.getUsername()) != null) {
            return "Username já cadastrado";
        }
        User user = new User();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setGender(input.getGender());
        user.setPassword(input.getPassword());
        user.setUsername(input.getUsername());
        user.setRole(input.getRole());
        userRepository.save(user);
        return "Usuário cadastrado com sucesso";
    }

    public String login(User loginDTO) throws LoginException {
        User userEmail = userRepository.findByEmail(loginDTO.getEmail());
//        User userPassword = userRepository.findByPassword(loginDTO.getPassword());
        if (userEmail == null) {
            return "Email ou senha inválidos.";
        } else {
            if (userEmail.getPassword().equals(loginDTO.getPassword())) {
                return userEmail.getUsername();
            } else {
                return "Email ou senha inválidos.";
            }
        }
    }

    public String updateUser(UUID id, User userUpdate) {
        User user = userRepository.findById(id).get();
        user.setName(userUpdate.getName());
        user.setUsername(userUpdate.getUsername());
        userRepository.save(user);
        return user.getUsername();
    }

    public User getUserId(UUID id) {
        return userRepository.findById(id).get();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
