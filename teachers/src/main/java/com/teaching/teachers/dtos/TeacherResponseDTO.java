package com.teaching.teachers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String school;

    // Optional: you can add computed fields later, e.g.
    // private String fullName = firstName + " " + lastName;
}