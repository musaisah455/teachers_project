// AuthenticationRequest.java
package com.teaching.teachers.dtos;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}