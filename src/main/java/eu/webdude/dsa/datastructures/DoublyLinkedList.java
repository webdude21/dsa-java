package eu.webdude.dsa.datastructures;

import java.util.ArrayList;
import java.util.Iterator;

public class DoublyLinkedList<E> implements Iterable<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size;

    public int size() {
        return this.size;
    }

    public void addFirst(E val) {
        Node<E> oldHead = head;
        head = new Node<>(val, oldHead, null);
        handleFirstElement(head);
        if (oldHead != null) {
            head.setNext(oldHead);
            oldHead.setPrev(head);
        }
        size++;
    }

    public void addLast(E val) {
        Node<E> oldTail = tail;
        tail = new Node<>(val, null, oldTail);
        handleFirstElement(tail);
        if (oldTail != null) {
            tail.setPrev(oldTail);
            oldTail.setNext(tail);
        }
        size++;
    }

    public E removeFirst() {
        validateRemoveOperation();
        E result = head.value;
        head = head.getNext();

        if (head != null) {
            head.setPrev(null);
        }

        size--;

        handleLastElementRemoval();
        return result;
    }

    public E removeLast() {
        validateRemoveOperation();
        E result = tail.value;
        tail = tail.getPrev();

        if (tail != null) {
            tail.setNext(null);
        }

        size--;
        handleLastElementRemoval();
        return result;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        ArrayList<E> list = new ArrayList<>();
        this.forEach(list::add);
        return (E[]) list.toArray();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E val = current.getValue();
                current = current.getNext();
                return val;
            }
        };
    }

    private void handleFirstElement(Node<E> el) {
        if (size() != 0) {
            return;
        }

        el.setNext(null);
        el.setPrev(null);

        head = el;
        tail = el;
    }

    private void handleLastElementRemoval() {
        if (size() == 0) {
            head = null;
            tail = null;
        }
    }

    private void validateRemoveOperation() {
        if (this.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public class Node<T> {
        private final T value;

        private Node<T> next;

        private Node<T> prev;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.prev = previous;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }
    }
}

