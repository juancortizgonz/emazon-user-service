package com.emazon.user_service.infrastructure.security.service;

import com.emazon.user_service.application.dto.auth.AuthRequest;
import com.emazon.user_service.application.dto.auth.AuthResponse;
import com.emazon.user_service.domain.exception.AuthenticationFailException;
import com.emazon.user_service.infrastructure.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IUserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthResponse auth(AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getEmail(),
                    authRequest.getPassword()
            ));

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            Long userId = userRepository.findByUserEmail(authRequest.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"))
                    .getUserId();

            String jwtToken = jwtService.getToken(userDetails, userId);

            return AuthResponse.builder().token(jwtToken).build();
        } catch (UsernameNotFoundException e) {
            throw new AuthenticationFailException("Authentication failed");
        }
    }
}
