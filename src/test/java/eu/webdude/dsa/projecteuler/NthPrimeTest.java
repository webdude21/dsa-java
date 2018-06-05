package eu.webdude.dsa.projecteuler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.math.BigInteger;
import java.util.stream.Stream;

class NthPrimeTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(2, BigInteger.valueOf(3)),
      Arguments.of(6, BigInteger.valueOf(13)),
      Arguments.of(10, BigInteger.valueOf(29)),
      Arguments.of(10_001, BigInteger.valueOf(104_743))
    );
  }

  @ParameterizedTest
  @ArgumentsSource(NthPrimeTest.class)
  void nThPrime(int input, BigInteger expected) {
    Assertions.assertEquals(expected, NthPrime.nThPrime(input));
  }

  @ParameterizedTest
  @ArgumentsSource(SumOfPrimesArguments.class)
  void sumOfPrimes(int input, long expected) {
    Assertions.assertEquals(expected, NthPrime.sumOfPrimes(input));
  }

  static class SumOfPrimesArguments implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
      return Stream.of(
        Arguments.of(10, 17L),
        Arguments.of(2_000_000, 142_913_828_922L)
      );
    }
  }
}
