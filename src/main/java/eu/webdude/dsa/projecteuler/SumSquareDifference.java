package eu.webdude.dsa.projecteuler;

import java.util.stream.IntStream;

public class SumSquareDifference {

  static int solve(int n) {
    int sum = IntStream.rangeClosed(1, n).sum();
    int squaresSum = IntStream.rangeClosed(1, n).map(num -> num * num).sum();
    int sumsSquared = sum * sum;

    return sumsSquared - squaresSum;
  }
}
