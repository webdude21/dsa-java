package eu.webdude.dsa.projecteuler;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplesOf3and5Test implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(10, 23),
      Arguments.of(1000, 233168)
    );
  }

  @ParameterizedTest
  @ArgumentsSource(MultiplesOf3and5Test.class)
  void solution(int input, int expected) {
    assertEquals(expected, MultiplesOf3and5.solution(input));
  }
}
