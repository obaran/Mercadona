package com.onur.mercadona.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JwtTokenProvider {

    // Méthode pour résoudre le token à partir de la requête HTTP
    public String resolveToken(HttpServletRequest request) {
        // Implémentez la logique pour extraire le token de l'entête 'Authorization'
        return null;
    }

    // Méthode pour valider le token JWT
    public boolean validateToken(String token) {
        // Implémentez la logique pour valider le token JWT
        return false;
    }

    // Méthode pour obtenir l'Authentication à partir du token JWT
    public Authentication getAuthentication(String token) {
        // Implémentez la logique pour extraire l'information d'authentification à partir du token
        return null;
    }
}
