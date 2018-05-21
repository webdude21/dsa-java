package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import java.util.stream.IntStream;

class Multiplications {
  static int multiply(int a, int b) {
    return IntStream.range(0, b).map(i -> a).sum();
  }

  static int multiplyRecursive(int a, int b) {
    if (a > b) {
      multiplyRecursive(b, a);
    }

    return multiplyRecursiveInternal(a, b);
  }

  private static int multiplyRecursiveInternal(int smaller, int bigger) {
    if (smaller == 1) {
      return bigger;
    }

    return bigger + multiply(smaller - 1, bigger);
  }
}
