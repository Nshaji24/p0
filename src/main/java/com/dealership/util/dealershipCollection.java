package com.dealership.util;
import com.dealership.model.User;


public abstract class dealershipCollection {
    protected int maxSize;

    public abstract Object get(Object o);

    public abstract void add(User u) throws Exception;

    public abstract int size();

    public abstract void remove(Object o);

    public abstract Object next();

    public abstract Object previous();

    public abstract String toString();

    abstract boolean isEmpty();

    protected abstract void clear();
}
