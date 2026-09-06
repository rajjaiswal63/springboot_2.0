package com.security.springsecurity2.controller;

import com.security.springsecurity2.dto.LogInDto;
import com.security.springsecurity2.dto.LoginResponseDTO;
import com.security.springsecurity2.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LogInDto logInDto) {
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(
                        logInDto.getUsername(), logInDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationRequest);

        String token = jwtService.generateToken(authentication);

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setAccessToken(token);
        return  new ResponseEntity<>(loginResponseDTO, HttpStatus.OK);

    }
}
