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
		moveTail();
	}

	public E dequeue() {
		ensureQueueIsNotEmpty();
		E result = store[startIndex];
		size--;
		moveHead();
		return result;
	}

	@SuppressWarnings("unchecked")
	public E[] toArray() {
		E[] resultArray = (E[]) new Object[size];

		int currentIndex = startIndex;

		for (int i = 0; i < size; i++) {
			resultArray[i] = store[currentIndex];
			currentIndex = getNextIndex(currentIndex);
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
		int oldStartIndex = startIndex;
		int oldEndIndex = endIndex;
		int currentIndex = oldStartIndex;

		initStore();

		boolean passedTheEnd = false;

		while (!passedTheEnd || currentIndex <= oldEndIndex) {
			enqueue(oldStore[currentIndex]);
			if (currentIndex == oldStore.length - 1) {
				currentIndex = 0;
				passedTheEnd = true;
			} else {
				currentIndex++;
			}
		}
	}

	private int getNextIndex(int currentIndex) {
		if (currentIndex == store.length - 1) {
			return 0;
		} else {
			return currentIndex + 1;
		}
	}

	private void moveTail() {
		if (endIndex == startIndex - 1) {
			return;
		}

		if (endIndex == store.length - 1) {
			endIndex = 0;
		} else {
			endIndex++;
		}
	}

	private void moveHead() {
		if (startIndex == store.length - 1) {
			startIndex = 0;
		} else {
			startIndex++;
		}
	}
}
