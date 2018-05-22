package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.stream.Stream;

class StringPermutationsTest {

  @ParameterizedTest
  @ArgumentsSource(PermsWithoutDupsArgumentsProvider.class)
  void permutationsWithoutDuplicates(String input, String[] expected) {
    Object[] actual = StringPermutations.permutationsWithoutDuplicates(input).toArray();
    Arrays.sort(actual);
    Arrays.sort(expected);
    Assertions.assertArrayEquals(expected, actual);
  }

  private static class PermsWithoutDupsArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
      return Stream.of(
        Arguments.of("abc", new String[]{"abc", "acb", "bca", "bac", "cab", "cba"})
      );
    }
  }
}
