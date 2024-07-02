package com.pair.authService.business.concretes;

import com.pair.authService.business.abstracts.AuthService;
import com.pair.authService.business.abstracts.UserService;
import com.pair.authService.business.dtos.requests.LoginRequest;
import com.pair.authService.business.dtos.requests.RegisterRequest;
import com.pair.authService.business.rules.AuthBusinessRules;
import com.pair.corePackage.jwt.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthManager implements AuthService {
    private final JwtService jwtService;
    private final UserService userService;
    private final AuthBusinessRules authBusinessRules;

    @Override
    public void register(RegisterRequest request) {
        userService.add(request);
    }

    @Override
    public String login(LoginRequest request) {
        authBusinessRules.authenticationControl(request);

        UserDetails user = userService.loadUserByUsername(request.getEmail());

        return jwtService.generateToken(user.getUsername(), user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
    }
}
// 9:10