package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private String role;
	private String profileImage;


	}
