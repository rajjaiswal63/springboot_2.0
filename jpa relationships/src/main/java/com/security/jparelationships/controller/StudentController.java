package com.security.jparelationships.controller;

import com.security.jparelationships.payload.RequestStudentDto;
import com.security.jparelationships.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create/{departmentId}")
    public ResponseEntity<?> createStudent(@RequestBody RequestStudentDto requestStudentDto,
                                           @PathVariable Long departmentId){
        studentService.create(requestStudentDto,departmentId);
        return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }

    @PostMapping("/create/newdep")
    public ResponseEntity<?> createStudentWithNewDep(@RequestBody RequestStudentDto requestStudentDto,
                                           @RequestParam String departmentName){
        studentService.createWithNewDep(requestStudentDto,departmentName);
        return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }

}
