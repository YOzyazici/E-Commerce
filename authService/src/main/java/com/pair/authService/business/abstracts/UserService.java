package com.pair.authService.business.abstracts;


import com.pair.authService.business.dtos.requests.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void add(RegisterRequest request);
}
