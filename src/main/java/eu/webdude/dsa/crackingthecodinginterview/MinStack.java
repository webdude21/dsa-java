package eu.webdude.dsa.crackingthecodinginterview;


import java.util.LinkedList;

class MinStack<T extends Comparable<T>> {

  private LinkedList<T> store = new LinkedList<>();
  private LinkedList<T> mins = new LinkedList<>();

  void push(T input) {
    mins.push(this.mins.size() == 0 ? input : getMin(input, this.mins.peek()));
    store.addLast(input);
  }

  T pop() {
    mins.pop();
    return store.getLast();
  }

  T min() {
    return mins.peek();
  }

  private T getMin(T a, T b) {
    return a.compareTo(b) < 0 ? a : b;
  }
}
