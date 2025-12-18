package com.example.EmployeeManagement.payloads;

import com.example.EmployeeManagement.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Transient;

import java.util.Date;

@Getter
@Setter
public class EmployeeDto {
    private String employeeId;
    @NotBlank
    private String name;
    @Email
    private String email;

    private String password;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String address;
    @NotBlank
    private String gender;
    @CreatedDate
    private Date createdAt;
    @NotNull
    private Role role;
}
