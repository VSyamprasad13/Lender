package com.lenderApp.lender.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.lenderApp.lender.entity.Users;
import com.lenderApp.lender.repository.UsersRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);
            try {
                Long mobile = Long.parseLong(jwtUtility.extractMobile(jwt));

                if (mobile != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    Optional<Users> userOptional = usersRepository.findByUserID(mobile);
                    if (userOptional.isPresent() && jwtUtility.validateToken(jwt, mobile)) {
                        Users user = userOptional.get();
                        List<GrantedAuthority> authorities = Collections.singletonList(
                            new SimpleGrantedAuthority(user.getRole())
                        );

                        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                            user, null, authorities
                        );
                        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(token);
                    }
                }
            } catch (Exception e) {
                // Optional: log token parsing/validation error
            }
        }

        chain.doFilter(request, response);
    }
}
