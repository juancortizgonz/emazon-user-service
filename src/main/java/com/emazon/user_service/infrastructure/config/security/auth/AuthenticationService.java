package com.emazon.user_service.infrastructure.config.security.auth;

import com.emazon.user_service.application.dto.auth.AuthenticationRequest;
import com.emazon.user_service.application.dto.auth.AuthenticationResponse;
import com.emazon.user_service.domain.exception.AuthenticationFailException;
import com.emazon.user_service.infrastructure.config.security.jwt.JwtService;
import com.emazon.user_service.infrastructure.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse auth(AuthenticationRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            ));

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            Long userId = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"))
                    .getUserId();

            String jwtToken = jwtService.getToken(userDetails, userId);

            return AuthenticationResponse.builder().generatedToken(jwtToken).build();
        } catch (UsernameNotFoundException e) {
            throw new AuthenticationFailException("User not found");
        }
    }
}
