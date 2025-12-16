package com.ecommerce.entity;

import java.time.LocalDateTime;

import javax.management.relation.Role;

import org.springframework.cglib.core.Local;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.*;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Username required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    
    @NotBlank(message = "Email is required")
    @Size(message = "Email must be valid")                                                   
    @Column(unique=true, nullable = false)
    private String email;
    
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @NotBlank(message = "Last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private Role role=Role.USER;
    public enum Role {
        ADMIN,
        USER
    }
}   
