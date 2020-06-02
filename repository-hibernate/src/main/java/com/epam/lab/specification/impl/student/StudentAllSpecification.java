package com.epam.lab.specification.impl.student;

import com.epam.lab.model.impl.Student;
import com.epam.lab.specification.EntitySpecification;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class StudentAllSpecification implements EntitySpecification<Student> {

    @Override
    public TypedQuery<Student> specified(EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root);
        return entityManager.createQuery(query);
    }

}
