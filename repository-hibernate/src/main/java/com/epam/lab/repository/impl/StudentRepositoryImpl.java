package com.epam.lab.repository.impl;

import com.epam.lab.exception.InsertException;
import com.epam.lab.exception.RemoveException;
import com.epam.lab.exception.UpdateException;
import com.epam.lab.model.impl.Student;
import com.epam.lab.repository.StudentRepository;
import com.epam.lab.specification.EntitySpecification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Student add(Student student) {
        entityManager.persist(student);
        if (Objects.isNull(student.getId())) {
            throw new InsertException("Student wasn't inserted");
        }
        return student;
    }

    @Override
    @Transactional
    public Student update(Student student) {
        Student studentToUpdate = entityManager.find(Student.class, student.getId());
        if (Objects.isNull(studentToUpdate)) {
            throw new UpdateException("No such student to update");
        }
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public Boolean remove(Student student) {
        Student studentToRemove = entityManager.find(Student.class , student.getId());
        if (Objects.isNull(studentToRemove)) {
            throw new RemoveException("No such student to remove");
        }
        entityManager.remove(studentToRemove);
        return true;
    }

    @Override
    @Transactional
    public List<Student> query(EntitySpecification<Student> specification) {
        return specification.specified(entityManager).getResultList();
    }
}
