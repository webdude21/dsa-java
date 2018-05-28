package eu.webdude.dsa.projecteuler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class LargestPalindromeProductTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(2, 9009L),
      Arguments.of(3, 906609L)
    );
  }

  @ParameterizedTest
  @ArgumentsSource(LargestPalindromeProductTest.class)
  void solve(int digits, long expected) {
    Assertions.assertEquals(expected, LargestPalindromeProduct.solve(digits));
  }
}
