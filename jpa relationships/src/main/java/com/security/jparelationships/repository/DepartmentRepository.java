package com.security.jparelationships.repository;

import com.security.jparelationships.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Department requestDepartment) {
        entityManager.persist(requestDepartment);
    }

    @Transactional
    public Department getDepartmentById(Long departmentId) {
        return entityManager.find(Department.class, departmentId);
    }
}
