package com.airtribe.ems.entity;

import com.airtribe.ems.entity.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(min = 5, max = 100, message = "Email must be between 5 and 100 characters")
    @Column(name = "email_id", unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Role is required")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToMany
    @JoinTable(name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects;
}
