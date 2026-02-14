package com.teaching.teachers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TeacherRequestDTO {

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be 2–50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be 2–50 characters")
    private String lastName;

    @NotBlank(message = "Address is required")
    @Size(min = 5, max = 150, message = "Address must be 5–150 characters")
    private String address;

    @NotBlank(message = "School is required")
    @Size(min = 3, max = 100, message = "School must be 3–100 characters")
    private String school;
}