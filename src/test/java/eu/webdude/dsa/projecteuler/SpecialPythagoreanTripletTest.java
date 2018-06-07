package eu.webdude.dsa.projecteuler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class SpecialPythagoreanTripletTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(31_875_000L, 1000),
      Arguments.of(97_500_000L, 1500)
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SpecialPythagoreanTripletTest.class)
  void solve(long expected, int input) {
    Assertions.assertEquals(expected, SpecialPythagoreanTriplet.solve(input));
  }
}
