package com.security.jparelationships.service;

import com.security.jparelationships.model.Department;
import com.security.jparelationships.model.Student;
import com.security.jparelationships.repository.DepartmentRepository;
import com.security.jparelationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentService {

    DepartmentRepository departmentRepository;
    StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository, StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void create(Department requestDepartment) {
        departmentRepository.save(requestDepartment);
    }
    @Transactional
    public void createWithStudentName(Department department, String studentName) {
        departmentRepository.save(department);

        Student student = new Student();
        student.setName(studentName);
        student.setDepartment(department);

        if (department.getStudents() == null) {
            department.setStudents(new ArrayList<>());
        }
        department.getStudents().add(student);
        studentRepository.save(student);
    }
}
