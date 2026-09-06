package com.security.springsecurity2.controller;

import com.security.springsecurity2.entity.Role;
import com.security.springsecurity2.repository.RoleRepository;
import com.security.springsecurity2.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private RoleService roleService;
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/add")
    public String addRole(@RequestBody Role role) {
        roleService.addRole(role);
        return "Done";
    }
}
