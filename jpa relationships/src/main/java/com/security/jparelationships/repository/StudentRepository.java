package com.security.jparelationships.repository;

import com.security.jparelationships.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
