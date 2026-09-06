package com.security.springsecurity2.service;

import com.security.springsecurity2.Config.SecurityConfig;
import com.security.springsecurity2.dto.RegisterDto;
import com.security.springsecurity2.dto.RegisterResponseDto;
import com.security.springsecurity2.entity.Role;
import com.security.springsecurity2.entity.User;
import com.security.springsecurity2.repository.RoleRepository;
import com.security.springsecurity2.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncode) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncode;

    }

    public RegisterResponseDto register(RegisterDto registerDto) {
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEnabled(true);

        String encodedPassword = passwordEncoder.encode(registerDto.getPassword());
        user.setPassword(encodedPassword);

        Role role = roleRepository.findByName("USER_ROLE");

        if (role == null) {
            throw new RuntimeException("USER_ROLE not found");
        }

        user.getRoles().add(role);


        userRepository.save(user);
        RegisterResponseDto responseDto = new RegisterResponseDto();
        responseDto.setUsername(registerDto.getUsername());
        responseDto.setMessage("saved");
        return responseDto;
    }
}
