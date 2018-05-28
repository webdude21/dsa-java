package eu.webdude.dsa.projecteuler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class SmallestMultipleTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(10, 2520),
      Arguments.of(20, 232792560)
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SmallestMultipleTest.class)
  void solveBruteForce(int limit, int expected) {
    Assertions.assertEquals(expected, SmallestMultiple.solveBruteForce(limit));
  }


  @ParameterizedTest
  @ArgumentsSource(SmallestMultipleTest.class)
  void solve(int limit, int expected) {
    Assertions.assertEquals(expected, SmallestMultiple.solve(limit));
  }
}
