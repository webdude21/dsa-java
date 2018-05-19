package eu.webdude.dsa.crackingthecodinginterview;

import java.util.stream.IntStream;

class RecursionAndDynamicProgramming {

  static int tripleStep(int n) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    } else {
      return IntStream.rangeClosed(1, 3).map(i -> tripleStep(n - i)).sum();
    }
  }
}
