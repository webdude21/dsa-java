package eu.webdude.dsa.datastructures;

import java.util.ArrayList;
import java.util.function.Consumer;

class BinarySearchTree<T extends Comparable<T>> {
  private Node root;

  Node getRoot() {
    return this.root;
  }

  private void setRoot(Node root) {
    this.root = root;
  }

  void insert(T value) {
    var node = new Node(value);
    var currentNode = root;
    var previousNode = root;

    if (root == null) {
      root = new Node(value);
      return;
    }

    while (currentNode != null) {
      previousNode = currentNode;
      currentNode = getNextNode(currentNode, value);
    }

    if (previousNode.getValue().compareTo(value) > 0) {
      previousNode.setLeft(node);
    } else {
      previousNode.setRight(node);
    }
  }

  boolean contains(T value) {
    return this.search(value).getRoot() != null;
  }

  BinarySearchTree<T> search(T item) {
    BinarySearchTree<T> result;
    var currentNode = root;

    if (currentNode == null || item == null) {
      return null;
    }

    while (currentNode != null) {
      if (currentNode.getValue().equals(item)) {
        break;
      }

      currentNode = getNextNode(currentNode, item);
    }

    return getBST(currentNode);
  }

  Iterable<T> range(T from, T to) {
    var result = new ArrayList<T>();

    eachInOrder(node -> {
      boolean isInRange = node.compareTo(from) >= 0 && node.compareTo(to) <= 0;
      if (isInRange) {
        result.add(node);
      }
    }, root);

    return result;
  }

  private BinarySearchTree<T> getBST(Node node) {
    BinarySearchTree<T> bst = new BinarySearchTree<>();
    bst.setRoot(node);
    return bst;
  }

  private Node getNextNode(Node node, T value) {
    var compareResult = node.getValue().compareTo(value);

    if (compareResult > 0) {
      node = node.getLeft();
    } else if (compareResult < 0) {
      node = node.getRight();
    }

    return node;
  }

  private void doUnlessNull(Node node, Consumer<Node> consumer) {
    if (node != null) {
      consumer.accept(node);
    }
  }

  private void eachInOrder(Consumer<T> consumer, Node root) {
    doUnlessNull(root.getLeft(), node -> eachInOrder(consumer, root.getLeft()));
    doUnlessNull(root, node -> consumer.accept(node.getValue()));
    doUnlessNull(root.getRight(), node -> eachInOrder(consumer, root.getRight()));
  }

  class Node {
    private T value;

    private Node left;

    private Node right;

    Node(T value) {
      this.value = value;
    }

    T getValue() {
      return this.value;
    }

    public void setValue(T value) {
      this.value = value;
    }

    Node getLeft() {
      return this.left;
    }

    void setLeft(Node left) {
      this.left = left;
    }

    Node getRight() {
      return this.right;
    }

    void setRight(Node right) {
      this.right = right;
    }
  }
}

