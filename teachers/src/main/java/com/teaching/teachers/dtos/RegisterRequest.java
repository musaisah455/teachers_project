// RegisterRequest.java
package com.teaching.teachers.dtos;

import com.teaching.teachers.user.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
}