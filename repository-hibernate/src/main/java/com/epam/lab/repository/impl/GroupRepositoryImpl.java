package com.epam.lab.repository.impl;

import com.epam.lab.exception.InsertException;
import com.epam.lab.exception.RemoveException;
import com.epam.lab.exception.UpdateException;
import com.epam.lab.model.impl.Group;
import com.epam.lab.repository.GroupRepository;
import com.epam.lab.specification.EntitySpecification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Repository
public class GroupRepositoryImpl implements GroupRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Group add(Group group) {
        entityManager.persist(group);
        if (Objects.isNull(group.getId())) {
            throw new InsertException("Group wasn't inserted");
        }
        return group;
    }

    @Override
    @Transactional
    public Group update(Group group) {
        Group groupToUpdate = entityManager.find(Group.class, group.getId());
        if (Objects.isNull(groupToUpdate)) {
            throw new UpdateException("No such group to update");
        }
        return entityManager.merge(group);
    }

    @Override
    @Transactional
    public Boolean remove(Group group) {
        Group groupToRemove = entityManager.find(Group.class , group.getId());
        if (Objects.isNull(groupToRemove)) {
            throw new RemoveException("No such group to remove");
        }
        entityManager.remove(groupToRemove);
        return true;
    }

    @Override
    @Transactional
    public List<Group> query(EntitySpecification<Group> specification) {
        return specification.specified(entityManager).getResultList();
    }
}
