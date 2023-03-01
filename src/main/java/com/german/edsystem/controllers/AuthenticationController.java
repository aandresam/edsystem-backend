package com.german.edsystem.controllers;

import com.german.edsystem.config.jwt.AuthenticationCredentials;
import com.german.edsystem.config.jwt.JWTService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    @PostMapping
    public String authenticate(@RequestBody AuthenticationCredentials credentials) {
        Authentication authentication = authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(),
                                                                            credentials.getPassword()));
        if (!authentication.isAuthenticated()) {
            throw new UsernameNotFoundException("Credenciales incorectas");
        }
        return jwtService.generateToken(credentials.getUsername());
    }
}
