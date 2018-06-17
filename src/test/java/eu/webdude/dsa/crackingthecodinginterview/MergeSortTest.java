package eu.webdude.dsa.crackingthecodinginterview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class MergeSortTest implements ArgumentsProvider {

  class IntegerWrapper {
    int value;

    IntegerWrapper(int value) {
      this.value = value;
    }

    void add() {
      value++;
    }
  }

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(new Integer[]{1, 1, 1, 2, 2}, new Integer[]{1, 1, 1, 2, 2}, 0),
      Arguments.of(new Integer[]{1, 1, 2, 2, 3}, new Integer[]{2, 1, 3, 1, 2}, 4),
      Arguments.of(new String[]{"afa", "ba", "ca"}, new String[]{"ba", "afa", "ca"}, 2)
    );
  }

  @ParameterizedTest
  @ArgumentsSource(MergeSortTest.class)
  <T extends Comparable<T>> void sort(T[] expected, T[] input, int expectedInversionCount) {
    Assertions.assertArrayEquals(expected, MergeSort.sort(input));
  }

  @ParameterizedTest
  @ArgumentsSource(MergeSortTest.class)
  <T extends Comparable<T>> void sortWithInversionCount(T[] expected, T[] input, int expectedInversionCount) {
    IntegerWrapper actualInversionCount = new IntegerWrapper(0);
    Assertions.assertArrayEquals(expected, MergeSort.sort(input, t -> new IntegerWrapper(0).add()));
    Assertions.assertEquals(expectedInversionCount, actualInversionCount.value);
  }
}
