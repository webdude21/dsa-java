package eu.webdude.dsa.datastructures;

import java.util.function.Consumer;

public class BinaryTree<T> {

    private BinaryTree<T> parent;
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

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTree<T> getParent() {
        return parent;
    }

    public void setParent(BinaryTree<T> parent) {
        this.parent = parent;
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

    public String printIndentedPreOrder(int indent, StringBuilder builder) {
        return print(indent, builder);
    }

    private String print(int indent, StringBuilder builder) {
        builder.append(new String(new char[indent]).replace("\0", "  "));
        builder.append(getValue());
        builder.append(System.lineSeparator());
        doUnlessNull(getLeftChild(), node -> node.getLeftChild().print(indent + 1, builder));
        doUnlessNull(getRightChild(), node -> node.getRightChild().print(indent + 1, builder));
        return builder.toString();
    }

    private void doUnlessNull(BinaryTree<T> node, Consumer<BinaryTree<T>> consumer) {
        if (node != null) {
            consumer.accept(this);
        }
    }

    public void eachInOrder(Consumer<T> consumer) {
        doUnlessNull(getLeftChild(), node -> node.getLeftChild().eachInOrder(consumer));
        doUnlessNull(this, node -> consumer.accept(this.value));
        doUnlessNull(getRightChild(), node -> node.getRightChild().eachInOrder(consumer));
    }

    public void eachPostOrder(Consumer<T> consumer) {
        doUnlessNull(getLeftChild(), node -> node.getLeftChild().eachPostOrder(consumer));
        doUnlessNull(getRightChild(), node -> node.getRightChild().eachPostOrder(consumer));
        doUnlessNull(this, node -> consumer.accept(this.value));
    }
}
