package eu.webdude.dsa;

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
		head = new Node<E>(val, oldHead, null);
		size++;
	}

	private void handleFirstElement(Node<E> el) {
		if (size() != 0) {
			return;
		}

		head = el;
		tail = el;
	}

	public void addLast(E val) {
		Node<E> oldTail = tail;
		tail = new Node<E>(val, null, oldTail);
		size++;
	}

	public E removeFirst() {
		throw new UnsupportedOperationException();
	}

	public E removeLast() {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	public E[] toArray() {
		ArrayList<E> list = new ArrayList<E>();
		this.forEach(list::add);
		return (E[]) list.toArray();
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int idx;

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

	public class Node<T> {
		private Node<T> next;

		private Node<T> prev;

		private final T value;

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

