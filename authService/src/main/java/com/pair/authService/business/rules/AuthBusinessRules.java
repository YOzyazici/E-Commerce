package com.pair.authService.business.rules;

import com.pair.authService.business.dtos.requests.LoginRequest;
import com.pair.authService.business.messages.Messages;
import com.pair.corePackage.business.abstracts.MessageService;
import com.pair.corePackage.utils.exceptions.types.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthBusinessRules {

    private final AuthenticationManager authenticationManager;
    private final MessageService messageService;

    public void authenticationControl(LoginRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (AuthenticationException e) {
            throw new BusinessException(messageService.getMessage(Messages.IdentityErrors.AuthenticationFailed));
        }
    }
}
