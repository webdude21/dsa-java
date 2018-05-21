package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isIn;

class MagicIndexTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(Collections.singletonList(7), new int[]{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13}),
      Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5, 6), new int[]{0, 1, 2, 3, 4, 5, 6}),
      Arguments.of(Collections.singletonList(-1), new int[]{1, 2, 3, 4, 5, 6}),
      Arguments.of(Collections.singletonList(2), new int[]{-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(MagicIndexTest.class)
  void findExistingMagicIndex(Collection<Integer> expected, int[] input) {
    assertThat(MagicIndex.findMagicIndex(input), isIn(expected));
  }

  @ParameterizedTest
  @ArgumentsSource(MagicIndexTest.class)
  void findExistingMagicIndexWithBinarySearch(Collection<Integer> expected, int[] input) {
    assertThat(MagicIndex.findMagicIndexWithBinarySearch(input), isIn(expected));
  }
}
