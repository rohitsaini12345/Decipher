package com.example.service;

import com.example.controller.UserController;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
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
        logger.info("Registering new user:{}", user.getEmail());
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        logger.debug("Finding user by email: {}", email);

        return userRepository.findByEmail(email);
    }


    @Override
    public Optional<User> findById(Long id) {
        logger.debug("Finding user by ID: {}", id);
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(User user) {
        logger.info("Updating user with ID: {}", user.getId());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        logger.warn("Deleting user with ID: {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAllUsers() {
        logger.info("Fetching all users");
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
        logger.info("Saving a list of {} users", users.size());
        userRepository.saveAll(users);
    }


}
