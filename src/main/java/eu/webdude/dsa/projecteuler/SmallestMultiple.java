package eu.webdude.dsa.projecteuler;

import java.util.stream.LongStream;

class SmallestMultiple {

  static long solveNaive(int limit) {
    return LongStream
      .range(limit, (long) (Math.pow(limit, 10)))
      .filter(i -> isEvenlyDivisible(i, limit))
      .findFirst()
      .orElse(-1);
  }

  private static boolean isEvenlyDivisible(long number, int limit) {
    for (int j = limit; j > 0; j--) {
      if (number % j != 0) {
        return false;
      }
    }

    return true;
  }
}
