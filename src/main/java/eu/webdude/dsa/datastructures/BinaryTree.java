package eu.webdude.dsa.datastructures;

import java.util.function.Consumer;

public class BinaryTree<T> {

    public BinaryTree(T value) {
    }

    public BinaryTree(T value, BinaryTree<T> child) {
    }

    public BinaryTree(T value, BinaryTree<T> leftChild, BinaryTree<T> rightCHild) {
    }

    // append output to builder
    public String printIndentedPreOrder(int indent, StringBuilder builder) {
        throw new UnsupportedOperationException();
    }

    public void eachInOrder(Consumer<T> consumer) {
        throw new UnsupportedOperationException();
    }

    public void eachPostOrder(Consumer<T> consumer) {
        throw new UnsupportedOperationException();
    }
}
