package com.surfapp.auth;

import com.surfapp.user.UserDetailService;
import com.surfapp.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class AuthController {
    private UserDetailService userDetailsService;
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private JwtService jwtService;

    public AuthController(
            UserDetailService userDetailsService,
            UserRepository userRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            JwtService jwtService
    ) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping(path = "api/v1/login")
    public AuthenticatedUserDto login(
            @RequestParam String username,
            @RequestParam String password
    ) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UUID userId = userRepository.findByUsername(username).getId();
        if (bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
            String roles = userDetails.getAuthorities().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(","));
            String jwt = jwtService.createJwtForClaims(
                    username,
                    Map.of("roles", roles)
            );
            return new AuthenticatedUserDto(username, jwt, roles);
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
    }
}
