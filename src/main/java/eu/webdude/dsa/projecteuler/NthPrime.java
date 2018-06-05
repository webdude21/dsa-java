package eu.webdude.dsa.projecteuler;

import java.math.BigInteger;
import java.util.stream.LongStream;

class NthPrime {

  static long sumOfPrimes(int limit) {
    return LongStream.iterate(2, integer -> BigInteger.valueOf(integer).nextProbablePrime().longValue())
      .takeWhile(prime -> prime < limit)
      .sum();
  }

  static BigInteger nThPrime(int n) {
    var currentPrimeCount = 0;
    var currentPrime = BigInteger.ZERO;

    while (currentPrimeCount++ < n) {
      currentPrime = currentPrime.nextProbablePrime();
    }

    return currentPrime;
  }
}
