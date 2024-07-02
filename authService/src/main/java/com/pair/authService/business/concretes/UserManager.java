package com.pair.authService.business.concretes;

import com.pair.authService.business.abstracts.UserService;
import com.pair.authService.business.dtos.requests.RegisterRequest;
import com.pair.authService.dataAccess.abstracts.UserRepository;
import com.pair.authService.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    //todo: hata gözden geçirilecek
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new AccessDeniedException("Giriş başarısız."));
    }

    @Override
    public void add(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }

}
