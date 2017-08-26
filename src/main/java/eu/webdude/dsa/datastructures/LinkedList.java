package eu.webdude.dsa.datastructures;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private int size;

    private Node<E> head;

    public int size() {
        return this.size;
    }

    public void addFirst(E item) {
        Node<E> oldHead = head;
        head = new Node<>(item, oldHead);
        size++;
    }

    public void addLast(E item) {
        if (size() == 0) {
            addFirst(item);
            return;
        }

        Node<E> oldTail = this.getTail();
        oldTail.setNext(new Node<>(item, null));
        size++;
    }

    public E removeFirst() {
        validateRemoveOperation();
        E removedValue = head.getValue();
        head = head.getNext();
        size--;
        return removedValue;
    }

    public E removeLast() {
        if (size() == 1) {
            return removeFirst();
        }
        validateRemoveOperation();
        Node<E> elementBeforeLast = getAtPos(size() - 2);
        E removedValue = elementBeforeLast.getNext().getValue();
        elementBeforeLast.setNext(null);
        size--;
        return removedValue;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> currentEl = head;

            @Override
            public boolean hasNext() {
                return currentEl != null;
            }

            @Override
            public E next() {
                E value = currentEl.getValue();
                currentEl = currentEl.getNext();
                return value;
            }
        };
    }

    private void setSize(int size) {
        this.size = size;
    }

    private Node<E> getAtPos(int pos) {
        Node<E> currentNode = head;

        for (int i = 0; i < pos; i++) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException();
            }

            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    private Node<E> getTail() {
        return getAtPos(size() - 1);
    }

    private void validateRemoveOperation() {
        if (this.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public class Node<T> {

        private final T value;

        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
