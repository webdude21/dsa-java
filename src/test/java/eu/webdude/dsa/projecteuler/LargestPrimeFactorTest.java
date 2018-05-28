package eu.webdude.dsa.projecteuler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class LargestPrimeFactorTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(13195L, 29L),
      Arguments.of(600851475143L, 6857L)
    );
  }

  @ParameterizedTest
  @ArgumentsSource(LargestPrimeFactorTest.class)
  void solve(long input, long expected) {
    Assertions.assertEquals(expected, LargestPrimeFactor.solve(input));
  }
}
