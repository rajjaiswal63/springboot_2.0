package com.security.jparelationships.controller;

import com.security.jparelationships.model.Department;
import com.security.jparelationships.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?>createDepartment
            (@RequestBody Department requestDepartment){
        departmentService.create(requestDepartment);
        return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }

    @PostMapping("/create/withstudent")
    public ResponseEntity<?>createDepartmentWithStudent
            (@RequestBody Department requestDepartment,
             @RequestParam String studentName){
        departmentService.createWithStudentName(requestDepartment,studentName);
        return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }
}
