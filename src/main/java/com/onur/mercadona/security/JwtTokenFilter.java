package com.onur.mercadona.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;


public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    // Injectez le JwtTokenProvider via le constructeur
    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request,
                                    jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain)
            throws jakarta.servlet.ServletException, IOException {
        String token = jwtTokenProvider.resolveToken(request);

        // Validez le token
        if (token != null && jwtTokenProvider.validateToken(token)) {
            // Récupérez l'authentification à partir du token
            Authentication auth = jwtTokenProvider.getAuthentication(token);

            // Définissez l'authentification dans le contexte de sécurité
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }
}

