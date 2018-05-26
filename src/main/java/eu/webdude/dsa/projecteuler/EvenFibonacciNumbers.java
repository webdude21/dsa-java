package eu.webdude.dsa.projecteuler;

import java.math.BigInteger;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

class EvenFibonacciNumbers {

  static BigInteger sum(long limit) {
    UnaryOperator<BigInteger[]> fibonacci = (m) -> new BigInteger[]{m[1], m[0].add(m[1])};
    Predicate<BigInteger> hasNotReachedTheLimit = n -> n.compareTo(BigInteger.valueOf(limit)) < 1;

    return Stream.iterate(new BigInteger[]{BigInteger.ONE, BigInteger.ONE}, fibonacci)
      .map(n -> fibonacci.apply(n)[0])
      .filter(EvenFibonacciNumbers::isEven)
      .takeWhile(hasNotReachedTheLimit)
      .reduce(BigInteger::add)
      .orElse(BigInteger.ZERO);
  }

  private static boolean isEven(BigInteger val) {
    return val.mod(BigInteger.TWO).equals(BigInteger.ZERO);
  }

  static BigInteger sumIterative(long limit) {
    var sum = BigInteger.ZERO;
    var fib = BigInteger.ONE;
    var prevFib = BigInteger.ONE;

    for (var i = 2; i < limit; i++) {
      var temp = fib;
      fib = fib.add(prevFib);
      prevFib = temp;

      if (fib.compareTo(BigInteger.valueOf(limit)) > 0) {
        return sum;
      }

      if (isEven(fib)) {
        sum = sum.add(fib);
      }
    }

    return sum;
  }
}
