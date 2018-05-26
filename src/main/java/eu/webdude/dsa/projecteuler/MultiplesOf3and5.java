package eu.webdude.dsa.projecteuler;

import java.util.stream.LongStream;

class MultiplesOf3and5 {

  static long solution(int limit) {
    return LongStream
      .range(1, limit)
      .filter(value -> value % 5 == 0 || value % 3 == 0)
      .sum();
  }
}
