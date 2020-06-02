package com.epam.lab.specification.impl.group;

import com.epam.lab.model.impl.Group;
import com.epam.lab.specification.EntitySpecification;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GroupIdSpecification implements EntitySpecification<Group> {

    private static final String ID_FIELD = "id";

    private Long id;

    public GroupIdSpecification(Long id) {
        this.id = id;
    }

    @Override
    public TypedQuery<Group> specified(EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> query = builder.createQuery(Group.class);
        Root<Group> root = query.from(Group.class);
        query.select(root).where(builder.equal(root.get(ID_FIELD), id));
        return entityManager.createQuery(query);
    }

}
