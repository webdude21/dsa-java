package eu.webdude.dsa.datastructures;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Objects;

public class DoublyLinkedList<E> implements Iterable<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size;

    public int size() {
        return this.size;
    }

    public void addFirst(E val) {
      var oldHead = head;
        head = new Node<>(val, oldHead, null);
        handleFirstElement(head);
        if (oldHead != null) {
            head.setNext(oldHead);
            oldHead.setPrev(head);
        }
        size++;
    }

    public void addLast(E val) {
      var oldTail = tail;
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
      var result = head.value;
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
      var result = tail.value;
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
        if (size == 0 || head == null || head.value == null) {
            return (E[]) new Object[this.size];
        }

      var arr = (E[]) Array.newInstance(head.value.getClass(), this.size);
      var index = 0;

      for (var item : this) {
            arr[index++] = item;
        }

        return arr;
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
              var val = current.getValue();
                current = current.getNext();
                return val;
            }
        };
    }

    public void removeDuplicates() {
      var head = this.head;
      var skipHead = head.next;

        while (true) {
            while (skipHead != null) {
              var newSkipHead = skipHead.next;

                if (skipHead.value.equals(head.value)) {
                    if (skipHead.prev != null) {
                        skipHead.prev.next = newSkipHead;
                    }

                    if (skipHead.next != null) {
                        skipHead.next.prev = newSkipHead;
                    }

                    size--;
                }

                skipHead = newSkipHead;
            }

            head = head.next;

            if (head == null || head.next == null) {
                return;
            }

            skipHead = head.next;
        }
    }

    public E nthToLast(int i) {
      var current = tail;

        while (i > 0 && current != null) {
            current = current.prev;
            i--;
        }

        return current != null ? current.value : null;
    }

    @Override
    public boolean equals(Object o) {
        // fast fail equals
        if (this == o) return true;
        if (!(o instanceof DoublyLinkedList)) return false;
      var that = (DoublyLinkedList<?>) o;
        if (size != that.size) return false;
        if (!(Objects.equals(head.value, that.head.value) && Objects.equals(tail.value, that.tail.value))) return false;

        return actualEquals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head.value, tail.value, size);
    }

    public void removeMiddleElement() {
      var slowPointer = head;
      var fastPointer = head;

        while (true) {
          var newSlowPointer = slowPointer.next;

            if (fastPointer.next == null) {
                slowPointer.prev.next = newSlowPointer;
                slowPointer.next.prev = newSlowPointer;
                size--;
                return;
            }

            slowPointer = newSlowPointer;
            fastPointer = fastPointer.next.next;
        }

    }

    public boolean isPalindrome() {
      var head = this.head;
      var tail = this.tail;

      for (var i = 0; i < size / 2; i++) {
            if (!head.value.equals(tail.value)) {
                return false;
            }

            head = head.next;
            tail = tail.prev;
        }

        return true;
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

    private boolean actualEquals(DoublyLinkedList<?> that) {
      var iterator = this.iterator();

        for (Object objectFromOther : that) {
            if (!objectFromOther.equals(iterator.next())) {
                return false;
            }
        }

        return true;
    }

  class Node<T> {
        private final T value;

        private Node<T> next;

        private Node<T> prev;

        Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.prev = previous;
        }

        Node<T> getPrev() {
            return prev;
        }

        void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        Node<T> getNext() {
            return next;
        }

        void setNext(Node<T> next) {
            this.next = next;
        }

        T getValue() {
            return value;
        }
    }
}

