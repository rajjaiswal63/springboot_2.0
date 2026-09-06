package com.security.springsecurity2.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterDto {
    @Column(nullable=false,unique = true)
    private String username;
    @Column(nullable=false)
    private String password;
}
