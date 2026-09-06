package com.security.springsecurity2.controller;

import com.security.springsecurity2.dto.RegisterDto;
import com.security.springsecurity2.dto.RegisterResponseDto;
import com.security.springsecurity2.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")

public class UserController {

    private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }
    @GetMapping("/hello")
    public String hello(Authentication authentication) {
        return "Hello "+ authentication.getName() ;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterDto registerDto) {
        RegisterResponseDto responseDto = authService.register(registerDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

    }
    @GetMapping("/token")
    public CsrfToken getCsrfToken(CsrfToken csrfToken) {
        return csrfToken;
    }
}
