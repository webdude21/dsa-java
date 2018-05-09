package eu.webdude.dsa.datastructures;

import java.util.function.Consumer;

public class BinaryTree<T> {

  private BinaryTree<T> parent;
  private T value;
  private BinaryTree<T> left;
  private BinaryTree<T> right;

  public BinaryTree(T value) {
    this.value = value;
  }

  public BinaryTree(T value, BinaryTree<T> child) {
    this.value = value;
    this.left = child;
  }

  public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public BinaryTree<T> getParent() {
    return parent;
  }

  public void setParent(BinaryTree<T> parent) {
    this.parent = parent;
  }

  public String printIndentedPreOrder(int indent, StringBuilder builder) {
    return print(indent, builder);
  }

  public void eachInOrder(Consumer<T> consumer) {
    doUnlessNull(getLeft(), node -> node.getLeft().eachInOrder(consumer));
    doUnlessNull(this, node -> consumer.accept(this.value));
    doUnlessNull(getRight(), node -> node.getRight().eachInOrder(consumer));
  }

  public void eachPostOrder(Consumer<T> consumer) {
    doUnlessNull(getLeft(), node -> node.getLeft().eachPostOrder(consumer));
    doUnlessNull(getRight(), node -> node.getRight().eachPostOrder(consumer));
    doUnlessNull(this, node -> consumer.accept(this.value));
  }

  BinaryTree<T> getLeft() {
    return left;
  }

  public void setLeft(BinaryTree<T> left) {
    this.left = left;
  }

  BinaryTree<T> getRight() {
    return right;
  }

  public void setRight(BinaryTree<T> right) {
    this.right = right;
  }

  private T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  private String print(int indent, StringBuilder builder) {
    builder.append(new String(new char[indent]).replace("\0", "  "));
    builder.append(getValue());
    builder.append(System.lineSeparator());
    doUnlessNull(getLeft(), node -> node.getLeft().print(indent + 1, builder));
    doUnlessNull(getRight(), node -> node.getRight().print(indent + 1, builder));
    return builder.toString();
  }

  private void doUnlessNull(BinaryTree<T> node, Consumer<BinaryTree<T>> consumer) {
    if (node != null) {
      consumer.accept(this);
    }
  }
}
