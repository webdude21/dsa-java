package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class StringPermutationsTest {

  @ParameterizedTest
  @ArgumentsSource(PermsWithoutDupsArgumentsProvider.class)
  void permutationsWithoutDuplicates(String input, String[] expected) {
    Assertions.assertArrayEquals(expected, StringPermutations.permutationsWithoutDuplicates(input).toArray());
  }

  private static class PermsWithoutDupsArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
      return Stream.of(
        Arguments.of("abc", new String[]{"aaa", "aab", "aac", "abb", "abc", "acc", "bbb", "bbc", "bcc", "ccc"})
      );
    }
  }
}
