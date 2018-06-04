package eu.webdude.dsa.projecteuler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class SumSquareDifferenceTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(10, 2640),
      Arguments.of(100, 25164150),
      Arguments.of(1000, 1058313332)
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SumSquareDifferenceTest.class)
  void solve(int input, int expected) {
    Assertions.assertEquals(expected, SumSquareDifference.solve(input));
  }

  @ParameterizedTest
  @ArgumentsSource(SumSquareDifferenceTest.class)
  void solveBruteForce(int input, int expected) {
    Assertions.assertEquals(expected, SumSquareDifference.solveBruteForce(input));
  }
}
