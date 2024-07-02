package com.pair.authService.business.abstracts;


import com.pair.authService.business.dtos.requests.LoginRequest;
import com.pair.authService.business.dtos.requests.RegisterRequest;

public interface AuthService {
    String login(LoginRequest request);
    void register(RegisterRequest request);
}
