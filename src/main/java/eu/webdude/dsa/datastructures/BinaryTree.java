package eu.webdude.dsa.datastructures;

import java.util.function.Consumer;

public class BinaryTree<T> {

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTree<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTree<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTree<T> rightChild) {
        this.rightChild = rightChild;
    }

    private T value;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree(T value) {
        this.value = value;
    }

    public BinaryTree(T value, BinaryTree<T> child) {
        this.value = value;
        this.leftChild = child;
    }

    public BinaryTree(T value, BinaryTree<T> leftChild, BinaryTree<T> rightCHild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightCHild;
    }

    // append output to builder
    public String printIndentedPreOrder(int indent, StringBuilder builder) {
        throw new UnsupportedOperationException();
    }

    public void eachInOrder(Consumer<T> consumer) {
        if (this.value == null) {
            return;
        }

        consumer.accept(this.value);

        if (this.getLeftChild() != null) {
            this.getLeftChild().eachInOrder(consumer);
        }

        if (this.getRightChild() != null) {
            this.getRightChild().eachInOrder(consumer);
        }

        this.getRightChild().eachInOrder(consumer);
    }

    public void eachPostOrder(Consumer<T> consumer) {
        throw new UnsupportedOperationException();
    }
}
