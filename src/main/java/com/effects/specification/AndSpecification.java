package com.swiggy.commons.specification;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by siddhants on 7/21/16.
 */
class AndSpecification<T> extends CompositeSpecification<T> {

    private Specification<T> left;
    private Specification<T> right;

    AndSpecification(Specification<T> left, Specification<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(T obj) {
        return left.isSatisfiedBy(obj) && right.isSatisfiedBy(obj);
    }

    @Override
    public <E> Predicate toPredicate(Root<E> root, CriteriaQuery query, CriteriaBuilder cb) {
        return cb.and(left.toPredicate(root, query, cb), right.toPredicate(root, query, cb));
    }


}