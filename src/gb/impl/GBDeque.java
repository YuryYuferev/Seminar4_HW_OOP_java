package src.gb.impl;

import java.util.Iterator;

public interface GBDeque<T> extends Iterable<T> {
    boolean addFirst(T type);
    boolean addLast(T type);

    public Iterator<T> descendingIterator();
}