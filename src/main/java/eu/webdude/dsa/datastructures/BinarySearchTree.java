package eu.webdude.dsa.datastructures;

import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    public Node getRoot() {
        return this.root;
    }

    void setRoot(Node root) {
        this.root = root;
    }

    public void insert(T value) {
        Node node = new Node(value);
        Node currentNode = root;
        Node previousNode = root;

        if (root == null) {
            root = new Node(value);
            return;
        }

        while (currentNode != null) {
            int compareResult = currentNode.getValue().compareTo(value);
            previousNode = currentNode;
            currentNode = getNextNode(currentNode, value);
        }

        if (previousNode.getValue().compareTo(value) > 0) {
            previousNode.setLeft(node);
        } else {
            previousNode.setRight(node);
        }
    }

    public boolean contains(T value) {
        return this.search(value).getRoot() != null;
    }

    private BinarySearchTree<T> getBST(Node node) {
        BinarySearchTree<T> bst = new BinarySearchTree<>();
        bst.setRoot(node);
        return bst;
    }

    public BinarySearchTree<T> search(T item) {
        BinarySearchTree<T> result;
        Node currentNode = root;

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

    private Node getNextNode(Node node, T value) {
        int compareResult = node.getValue().compareTo(value);

        if (compareResult > 0) {
            node = node.getLeft();
        } else if (compareResult < 0) {
            node = node.getRight();
        }

        return node;
    }

    private void doUnlessNull(Node node, Consumer<Node> consumer) {
        if (node != null) {
            consumer.accept(this.root);
        }
    }

    private void eachInOrder(Consumer<T> consumer) {
        doUnlessNull(root.getLeft(), node -> eachInOrder(consumer));
        doUnlessNull(root, node -> consumer.accept(node.getValue()));
        doUnlessNull(root.getRight(), node -> eachInOrder(consumer));
    }

    public Iterable<T> range(T from, T to) {
        throw new UnsupportedOperationException();
    }

    class Node {
        private T value;

        private Node left;

        private Node right;

        Node(T value) {
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

        void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        void setRight(Node right) {
            this.right = right;
        }
    }
}

