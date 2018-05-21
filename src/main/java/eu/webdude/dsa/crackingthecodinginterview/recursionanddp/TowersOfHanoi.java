package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import java.util.ArrayDeque;
import java.util.Deque;

class TowersOfHanoi<T extends Comparable<T>> {

  private final Deque<T> firstTower;
  private final Deque<T> secondTower;
  private final Deque<T> thirdTower;

  TowersOfHanoi(Deque<T> firstTower) {
    this.firstTower = firstTower;
    secondTower = new ArrayDeque<>();
    thirdTower = new ArrayDeque<>();
  }

  Deque<T> solve() {
    moveDisks(firstTower.size(), firstTower, thirdTower, secondTower);
    return thirdTower;
  }

  private void moveDisks(int n, Deque<T> origin, Deque<T> destination, Deque<T> buffer) {
    if (n <= 0) {
      return;
    }

    moveDisks(n - 1, origin, buffer, destination);

    destination.push(origin.pop());

    moveDisks(n - 1, buffer, destination, origin);
  }

}
