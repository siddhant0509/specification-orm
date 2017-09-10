package com.swiggy.commons.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by siddhants on 7/21/16.
 */
class NotSpecification<T> extends CompositeSpecification<T> {

    private Specification<T> specification;

    NotSpecification(Specification<T> specification) {
        this.specification = specification;
    }

    @Override
    public boolean isSatisfiedBy(T obj) {
        return !specification.isSatisfiedBy(obj);
    }

    @Override
    public <E> Predicate toPredicate(Root<E> root, CriteriaQuery query, CriteriaBuilder cb) {
        return cb.not(specification.toPredicate(root, query, cb));
    }

}
