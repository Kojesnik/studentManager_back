package com.epam.lab.specification.impl.student;

import com.epam.lab.model.impl.Student;
import com.epam.lab.specification.EntitySpecification;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class StudentIdSpecification implements EntitySpecification<Student> {

    private static final String ID_FIELD = "id";

    private Long id;

    public StudentIdSpecification(Long id) {
        this.id = id;
    }

    @Override
    public TypedQuery<Student> specified(EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root).where(builder.equal(root.get(ID_FIELD), id));
        return entityManager.createQuery(query);
    }

}
