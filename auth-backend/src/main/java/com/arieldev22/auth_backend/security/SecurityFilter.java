package com.arieldev22.auth_backend.security;

import com.arieldev22.auth_backend.services.AuthService;
import com.arieldev22.auth_backend.services.RevokedTokenService;
import com.arieldev22.auth_backend.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
    private TokenService tokenService;
    private AuthService authService;
    private RevokedTokenService revokedTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);

        if (token != null) {
            String userEmail = tokenService.validateToken(token);

            if ("EXPIRED".equals(userEmail)) {
                System.out.println("Token expirado recebido!");
            } else if (userEmail != null) {
                UserDetails user = authService.loadUserByUsername(userEmail);

                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                revokedTokenService.revokeToken(token);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        else return authHeader.replace("Bearer ", "");
    }
}
