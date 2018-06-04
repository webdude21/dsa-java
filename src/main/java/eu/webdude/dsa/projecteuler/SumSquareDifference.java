package eu.webdude.dsa.projecteuler;

import java.util.stream.IntStream;

public class SumSquareDifference {

  static int solveBruteForce(int n) {
    var sum = IntStream.rangeClosed(1, n).sum();
    var squaresSum = IntStream.rangeClosed(1, n).map(num -> num * num).sum();
    var sumsSquared = sum * sum;
    return sumsSquared - squaresSum;
  }

  public static int solve(int limit) {
    var sum = limit * (limit + 1) / 2;
    var squaresSum = (limit * 2 + 1) * (limit + 1) * limit / 6;
    var sumSquared = sum * sum;
    return sumSquared - squaresSum;
  }
}
