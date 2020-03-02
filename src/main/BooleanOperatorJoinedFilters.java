package main;

import java.util.List;

public class BooleanOperatorJoinedFilters<S, F extends Filter<S>> implements Filter<S> {
    private List<F> filters;
    private BooleanOperator operator;

    public BooleanOperatorJoinedFilters(List<F> filters, BooleanOperator operator) {
        this.filters = filters;
        this.operator = operator;
    }
    
    public boolean filter(S subject) {
        if (operator == BooleanOperator.And) {
            return filters.stream().allMatch(f -> f.filter(subject));
        } else {
            return filters.stream().anyMatch(f -> f.filter(subject));
        }
    }
}
