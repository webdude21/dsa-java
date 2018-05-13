package eu.webdude.dsa.datastructures;

import java.util.Iterator;

class LinkedList<E> implements Iterable<E> {

  private int size;

  private Node<E> head;

  public int size() {
    return this.size;
  }

  public void addFirst(E item) {
    var oldHead = head;
    head = new Node<>(item, oldHead);
    size++;
  }

  public void addLast(E item) {
    if (size() == 0) {
      addFirst(item);
      return;
    }

    var oldTail = this.getTail();
    oldTail.setNext(new Node<>(item, null));
    size++;
  }

  public E removeFirst() {
    validateRemoveOperation();
    var removedValue = head.getValue();
    head = head.getNext();
    size--;
    return removedValue;
  }

  public E removeLast() {
    if (size() == 1) {
      return removeFirst();
    }
    validateRemoveOperation();
    var elementBeforeLast = getAtPos(size() - 2);
    var removedValue = elementBeforeLast.getNext().getValue();
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
        var value = currentEl.getValue();
        currentEl = currentEl.getNext();
        return value;
      }
    };
  }

  private void setSize(int size) {
    this.size = size;
  }

  private Node<E> getAtPos(int pos) {
    var currentNode = head;

    for (var i = 0; i < pos; i++) {
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

  class Node<T> {

    private final T value;

    private Node<T> next;

    Node(T value, Node<T> next) {
      this.value = value;
      this.next = next;
    }

    T getValue() {
      return value;
    }

    Node<T> getNext() {
      return next;
    }

    void setNext(Node<T> next) {
      this.next = next;
    }
  }
}
