package com.security.jparelationships.service;

import com.security.jparelationships.model.Department;
import com.security.jparelationships.model.Student;
import com.security.jparelationships.payload.RequestStudentDto;
import com.security.jparelationships.repository.DepartmentRepository;
import com.security.jparelationships.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;
    DepartmentRepository departmentRepository;
    ModelMapper modelMapper = new ModelMapper();

    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    public void create(RequestStudentDto requestStudentDto, Long departmentId) {
        Student student = modelMapper.map(requestStudentDto, Student.class);
        Department department = departmentRepository.getDepartmentById(departmentId);
        student.setDepartment(department);

        department.getStudents().add(student);

        studentRepository.save(student);
    }

    public void createWithNewDep(RequestStudentDto requestStudentDto, String departmentName) {
        Student student = modelMapper.map(requestStudentDto, Student.class);

        Department department = new Department();
        department.setName(departmentName);
        department.getStudents().add(student);

        student.setDepartment(department);
        studentRepository.save(student);


    }
}
