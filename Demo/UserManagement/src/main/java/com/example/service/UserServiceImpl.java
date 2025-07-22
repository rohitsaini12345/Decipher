package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService, org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        log.info("Registering new user:{}", user.getEmail());
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        log.debug("Finding user by email: {}", email);

        return userRepository.findByEmail(email);
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().replace("ROLE_", ""))
                .build();
    }

    @Override
    public Optional<User> findById(Long id) {
        log.debug("Finding user by ID: {}", id);
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(User user) {
        log.info("Updating user with ID: {}", user.getId());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        log.warn("Deleting user with ID: {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public void saveAll(List<User> users) {
        for (User user : users) {

            String rawPassword = user.getPassword();
            if (rawPassword == null || rawPassword.isBlank()) {
                rawPassword = "default123";
            }
            user.setPassword(passwordEncoder.encode(rawPassword));


            if (user.getRole() == null || user.getRole().isEmpty()) {
                user.setRole("USER");
            }
        }
        log.info("Saving a list of {} users", users.size());
        userRepository.saveAll(users);
    }


}
