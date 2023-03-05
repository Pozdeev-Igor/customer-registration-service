package com.customerService.intsv.service;

import com.customerService.intsv.config.JwtService;
import com.customerService.intsv.dto.request.AuthenticationRequest;
import com.customerService.intsv.dto.request.RegisterRequest;
import com.customerService.intsv.dto.response.AuthenticationResponse;
import com.customerService.intsv.entity.User;
import com.customerService.intsv.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
            .firstName(request.getFirstname())
            .lastName(request.getLastname())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .build();
        repository.save(user);
        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
            .token(token)
            .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );
        User user = repository.findByEmail(request.getEmail())
            .orElseThrow();
        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
            .token(token)
            .build();
    }
}
