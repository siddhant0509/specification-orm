package com.swiggy.commons.specification;

/**
 * Created by siddhants on 7/22/16.
 */
public abstract class CompositeSpecification<T> implements Specification<T> {

    @Override
    public Specification<T> and(Specification<T> specification) {
            return new AndSpecification<T>(this, specification);
    }

    @Override
    public Specification<T> or(Specification<T> specification) {
        return new OrSpecification<T>(this, specification);
    }

    @Override
    public Specification<T> not() {
        return new NotSpecification<T>(this);
    }
}
