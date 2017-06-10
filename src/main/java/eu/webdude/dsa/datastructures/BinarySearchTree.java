package eu.webdude.dsa.datastructures;

import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    public BinarySearchTree() {
    }

    public Node getRoot() {
        return this.root;
    }

    public void insert(T value) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(T value) {
        throw new UnsupportedOperationException();
    }

    public BinarySearchTree<T> search(T item) {
        throw new UnsupportedOperationException();
    }

    public void eachInOrder(Consumer<T> consumer) {
        throw new UnsupportedOperationException();
    }

    public Iterable<T> range(T from, T to) {
        throw new UnsupportedOperationException();
    }

    class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}

