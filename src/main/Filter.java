package main;

public interface Filter<S> {
    public boolean filter(S subject);
}
