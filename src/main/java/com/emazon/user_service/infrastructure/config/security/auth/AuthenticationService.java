package com.emazon.user_service.infrastructure.config.security.auth;

import com.emazon.user_service.application.dto.auth.AuthenticationRequest;
import com.emazon.user_service.application.dto.auth.AuthenticationResponse;
import com.emazon.user_service.domain.exception.AuthenticationFailException;
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
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse auth(AuthenticationRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            ));

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            Long UserId = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"))
                    .getUserId();

            // #ToDo: Call JWT to generate the token, is necessary to pass the ID

            return AuthenticationResponse.builder().build();
        } catch (UsernameNotFoundException e) {
            throw new AuthenticationFailException("User not found");
        }
    }
}
