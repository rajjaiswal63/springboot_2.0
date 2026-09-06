package com.security.springsecurity2.repository;

import com.security.springsecurity2.entity.Role;
import com.security.springsecurity2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
