package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

class TowersOfHanoiTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(Arrays.asList(10, 7, 5, 3, 2, 1)),
      Arguments.of(Arrays.asList(25, 14, 12, 7, 4, -121)),
      Arguments.of(Arrays.asList("Zero", "Ten", "Eleven", "Average"))
    );
  }

  @ParameterizedTest
  @ArgumentsSource(TowersOfHanoiTest.class)
  <T> void towersOfHanoiTest(List<T> disks) {
    var instance = new TowersOfHanoi<>(new ArrayDeque<>(disks));
    Deque<T> result = instance.solve();
    Assertions.assertArrayEquals(disks.toArray(), result.toArray());
  }
}
