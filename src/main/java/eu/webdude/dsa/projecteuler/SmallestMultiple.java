package eu.webdude.dsa.projecteuler;

import java.util.stream.LongStream;

class SmallestMultiple {

  static long solveBruteForce(int limit) {
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

  static long solve(int limit) {
    return lcmRange(limit);
  }

  private static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  private static long lcm(long a, long b) {
    return a * (b / gcd(a, b));
  }

  private static long lcmRange(int limit) {
    return LongStream.rangeClosed(1, limit).reduce(1, SmallestMultiple::lcm);
  }
}
