package com.teaching.teachers.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "teachers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be 2–50 characters")
    @Column(nullable = false, length = 50)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be 2–50 characters")
    @Column(nullable = false, length = 50)
    private String lastName;

    @NotBlank(message = "Address is required")
    @Size(min = 10, max = 200, message = "Address must be 10–200 characters")
    @Column(nullable = false, length = 200)
    private String address;

    @NotBlank(message = "School is required")
    @Size(min = 10, max = 150, message = "School must be 10–150 characters")
    @Column(nullable = false, length = 150)
    private String school;

    // You can add later: @CreatedDate, @LastModifiedDate, etc.
}