package com.example.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.example.excel.ExcelExport;
import com.example.excel.ExcelImport;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UserController {
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        logger.info("Registration form");
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        logger.info("Registering with new email:{}",user.getEmail());
        userService.registerUser(user);

        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String showLoginForm() {
        logger.info(" login form");
        return "login";
    }

    @GetMapping("/profile")
    public String viewProfile(Model model, Principal principal) {
        logger.info("fetching profile of user:{}",principal.getName());
        User user = userService.findByEmail(principal.getName())
            .orElseThrow(() ->{
                logger.error("user not found with email:{}",principal.getName());
                 return new UsernameNotFoundException("User not found");
             });
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/user/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        logger.info("Opening edit form for user ID: {}", id);
        User user = userService.findById(id)
                      .orElseThrow(() ->{
                          logger.error("User not found for edit with ID: {}", id);
                          return new UsernameNotFoundException("User not found");
                      });
        model.addAttribute("user", user);
     
        return "editprofile";
    }


    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute User user,
                             @RequestParam(value = "image", required = false) MultipartFile file,
                             Principal principal) throws IOException {
        logger.info("Updating user with ID: {}", user.getId());

        if (file != null && !file.isEmpty()) {
            logger.info("Uploading profile image for user ID: {}", user.getId());
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path uploadPath = Paths.get("uploads");

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(filename);
            file.transferTo(filePath);

            user.setProfileImage(filename);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.updateUser(user);

        logger.info("Re-authenticating updated user: {}", user.getEmail());
        UserDetails updatedUser = userDetailsService.loadUserByUsername(user.getEmail());
        Authentication newAuth = new UsernamePasswordAuthenticationToken(
        updatedUser, updatedUser.getPassword(), updatedUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(newAuth);

        Set<String> roles = AuthorityUtils.authorityListToSet(newAuth.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            return "redirect:/admin";
        } else if (roles.contains("ROLE_USER")) {
            return "redirect:/profile";
        }

        return "redirect:/login?error";
    }

    @GetMapping("/images/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws MalformedURLException {
        Path file = Paths.get("uploads").resolve(filename);
        UrlResource resource = new UrlResource(file.toUri());

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .contentType(MediaTypeFactory.getMediaType(resource).orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body((Resource) resource);
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id, Principal principal) {
        logger.info(" delete user with ID: {}", id);

        boolean isSelfDelete = userService.findById(id)
                .map(user -> user.getEmail().equals(principal.getName()))
                .orElse(false);

        userService.deleteUser(id);
        logger.info("User deleted with ID: {}", id);

        if (isSelfDelete) {
            logger.warn("User deleted their own account: {}", principal.getName());
            SecurityContextHolder.clearContext();
            return "redirect:/login?deleted";
        }

        return "redirect:/admin";
    }


    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        logger.info("admin dashboard");
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping("/export-users")
    public void exportUsers(HttpServletResponse response) throws IOException {
        logger.info("Exporting users to Excel file");
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users.xlsx";
        response.setHeader(headerKey, headerValue);

        List<User> userList = userService.findAllUsers();
        ExcelExport exporter = new ExcelExport(userList);
        exporter.export(response);
        logger.info("Users exported successfully");
    }

    @PostMapping("/import-users")
    public ResponseEntity<String> importUsers(@RequestParam("file") MultipartFile file) throws IOException {
        logger.info("Importing users from uploaded Excel file: {}", file.getOriginalFilename());
        List<User> users = ExcelImport.parseExcelFile(file.getInputStream());
        userService.saveAll(users);
        logger.info("Imported {} users successfully", users.size());
        return ResponseEntity.ok("Users imported successfully!");
    }







}
