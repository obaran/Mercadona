package com.onur.mercadona.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


    public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    // Injectez le JwtTokenProvider via le constructeur
    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        // Récupérez le token JWT de l'entête de la requête
        String token = jwtTokenProvider.resolveToken(request);

        // Validez le token
        if (token != null && jwtTokenProvider.validateToken(token)) {
            // Récupérez l'authentification à partir du token
            Authentication auth = jwtTokenProvider.getAuthentication(token);

            // Définissez l'authentification dans le contexte de sécurité
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        chain.doFilter(request, response);
    }
}

