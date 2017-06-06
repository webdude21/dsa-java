package eu.webdude.dsa.datastructures;

public class CircularQueue<E> {

	private static int DEFAULT_CAPACITY = 8;

	private int size;

	private int capacity;

	private int startIndex;

	private int endIndex;

	private E[] store;

	public CircularQueue() {
		this(DEFAULT_CAPACITY);
	}

	public CircularQueue(int initialCapacity) {
		if (initialCapacity < DEFAULT_CAPACITY) {
			initialCapacity = DEFAULT_CAPACITY;
		}
		capacity = initialCapacity;
		store = initStore();
	}

	public int size() {
		return this.size;
	}

	public void enqueue(E element) {
		ensureCapacity();
		store[endIndex] = element;
		size++;
		endIndex = incrementPointer(endIndex, store);
	}

	public E dequeue() {
		ensureQueueIsNotEmpty();
		E result = store[startIndex];
		size--;
		startIndex = incrementPointer(startIndex, store);
		return result;
	}

	@SuppressWarnings("unchecked")
	public E[] toArray() {
		E[] resultArray = (E[]) new Object[size];

		int currentIndex = startIndex;

		for (int i = 0; i < size; i++) {
			resultArray[i] = store[currentIndex];
			currentIndex = incrementPointer(currentIndex, store);
		}

		return resultArray;
	}

	private void ensureQueueIsNotEmpty() {
		if (size == 0) {
			throw new IllegalArgumentException("The queue is empty. Nothing to dequeue");
		}

	}

	@SuppressWarnings("unchecked")
	private E[] initStore() {
		size = 0;
		store = (E[]) new Object[capacity];
		startIndex = capacity / 2;
		endIndex = startIndex;
		return store;
	}

	private void ensureCapacity() {
		if (size < store.length) {
			return;
		}

		capacity *= 2;

		E[] oldStore = store;
		int currentIndex = startIndex;

		initStore();

		for (E item : oldStore) {
			enqueue(oldStore[currentIndex]);
			currentIndex = incrementPointer(currentIndex, oldStore);
		}
	}

	private boolean doIndecesOverlap() {
		return endIndex == startIndex - 1;
	}

	private int incrementPointer(int pointer, E[] store) {
		return doIndecesOverlap() ? pointer : pointer == store.length - 1 ? 0 : pointer + 1;
	}
}
