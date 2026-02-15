package com.teaching.teachers.restcontroller;

import com.teaching.teachers.dtos.AuthenticationRequest;
import com.teaching.teachers.dtos.AuthenticationResponse;
import com.teaching.teachers.dtos.RegisterRequest;
import com.teaching.teachers.entities.User;
import com.teaching.teachers.repositories.UserRepository;
import com.teaching.teachers.services.JwtService;
import com.teaching.teachers.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole() != null ? request.getRole() : Role.USER)
                .build();

        //userRepository.save(user);

        //System.out.println(user);

       return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);

        //return ResponseEntity.ok(new AuthenticationResponse("User registered successfully"));

        //var jwt = jwtService.generateToken(user);
        // /return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        var jwt = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}