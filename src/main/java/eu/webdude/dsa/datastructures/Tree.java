package eu.webdude.dsa.datastructures;

import java.util.function.Consumer;

public class Tree<T> {

    public Tree(T value, Tree<T>... children) {
    }

    // append output to builder
    public String print(int indent, StringBuilder builder) {
        throw new UnsupportedOperationException();
    }

    public void each(Consumer<T> consumer) {
        throw new UnsupportedOperationException();
    }

    public Iterable<T> orderDFS() {
        throw new UnsupportedOperationException();
    }

    public Iterable<T> orderBFS() {
        throw new UnsupportedOperationException();
    }

}