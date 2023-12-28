package com.example.useraccountmanagementbackend.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.example.useraccountmanagementbackend.enumerator.EGender;
import com.example.useraccountmanagementbackend.enumerator.EMaritalStatus;
import com.example.useraccountmanagementbackend.enumerator.ERole;
import com.example.useraccountmanagementbackend.enumerator.EStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USERS", uniqueConstraints = @UniqueConstraint(columnNames = "EMAIL"))
@Data
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name="FIRST_NAME", length=20)
    private String firstName;
    @Column(name="LAST_NAME", length = 20)
    private String lastName;
    @Column(name = "GENDER", nullable = true)
    @Enumerated(EnumType.STRING)
    private EGender gender;
    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private EStatus status;
    @Column(name = "MARITAL_STATUS", nullable = true)
    @Enumerated(EnumType.STRING)
    private EMaritalStatus maritalStatus;
    @Column(name= "PHOTO")
    private String photo;
    @Column(name="EMAIL", length = 20, nullable = false)
    private String email;
    @Column(name="USERNAME", length = 20)
    private String username;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private ERole role;
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
}
