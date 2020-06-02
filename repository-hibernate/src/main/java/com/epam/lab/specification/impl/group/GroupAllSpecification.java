package com.epam.lab.specification.impl.group;

import com.epam.lab.model.impl.Group;
import com.epam.lab.specification.EntitySpecification;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GroupAllSpecification implements EntitySpecification<Group> {

    @Override
    public TypedQuery<Group> specified(EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> query = builder.createQuery(Group.class);
        Root<Group> root = query.from(Group.class);
        query.select(root);
        return entityManager.createQuery(query);
    }

}
