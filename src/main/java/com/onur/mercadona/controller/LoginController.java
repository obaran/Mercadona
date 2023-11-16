package com.onur.mercadona.controller;

import com.onur.mercadona.dto.LoginRequest;
import com.onur.mercadona.dto.LoginResponse;
import com.onur.mercadona.model.Admin;
import com.onur.mercadona.repository.AdminRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private AdminRepository adminRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginController() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }
    private static final String SECRET_KEY = "ezPv8iPTMSDpvlqFx+Tv5D4xDaOCl9eNbwGUj+Udr+s=";

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        Optional<Admin> adminOptional = adminRepository.findAdminByUsername(loginRequest.getUsername());
        if (adminOptional.isPresent() && bCryptPasswordEncoder.matches(loginRequest.getPassword(), adminOptional.get().getPassword())) {

            // Génération du token JWT
            String token = Jwts.builder()
                    .setSubject(loginRequest.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();

            return new LoginResponse(token);
        } else {
            // Gestion des identifiants invalides
            throw new RuntimeException("Identifiants incorrects");
        }
    }
}
