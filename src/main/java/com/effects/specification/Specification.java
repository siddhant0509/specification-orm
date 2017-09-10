package com.swiggy.commons.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Interface for Specification design pattern
 * to create filter queries.
 * Collection of <T> can be filtered by defining a
 * specification and passing them through
 * <code>isSatisfiedBy(T obj)</code>
 * Created by siddhants on 7/21/16.
 */
public interface Specification<T> {
    /**
     *
     * @param obj Object to be verified
     * @return true if object passed the criteria, else false
     */
    boolean isSatisfiedBy(T obj);

    /**
     *
     * @param specification Specification to be added as an and condition
     * @return New Specification Object
     */
    Specification<T> and(Specification<T> specification);

    /**
     *
     * @param specification Specification to be added as an or condition
     * @return New Specification Object
     */
    Specification<T> or(Specification<T> specification);

    /**
     *
     * @return New specification object which is not of given specifications
     */
    Specification<T> not();

    /**
     *
     * @param root Root of the Class <T>
     * @param query CriteriaQuery
     * @param cb CriteriaBuilder
     * @return new Predicate Object
     */
    <E> Predicate toPredicate(Root<E> root, CriteriaQuery query, CriteriaBuilder cb);


}
