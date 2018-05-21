package eu.webdude.dsa.crackingthecodinginterview;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isIn;
import static org.junit.jupiter.api.Assertions.*;

class RecursionAndDynamicProgrammingTest {

  private static final int MAX_JUMP_SIZE = 3;

  private static byte[][] grid = new byte[][]{
    new byte[]{0, 0, 0, 0, 0, 0, 1, 0},
    new byte[]{0, 0, 0, 0, 1, 0, 1, 0},
    new byte[]{0, 1, 0, 0, 1, 0, 1, 0},
    new byte[]{0, 0, 1, 0, 0, 0, 1, 0},
    new byte[]{1, 1, 0, 0, 0, 0, 1, 0},
    new byte[]{0, 0, 0, 1, 0, 0, 0, 0},
    new byte[]{0, 0, 0, 0, 1, 0, 1, 0},
    new byte[]{0, 0, 0, 0, 0, 0, 0, 0}
  };

  @ParameterizedTest
  @ArgumentsSource(MagicIndexArgumentProvider.class)
  void findExistingMagicIndex(Collection<Integer> expected, int[] input) {
    assertThat(RecursionAndDynamicProgramming.findMagicIndex(input), isIn(expected));
  }

  @ParameterizedTest
  @ArgumentsSource(MagicIndexArgumentProvider.class)
  void findExistingMagicIndexWithBinarySearch(Collection<Integer> expected, int[] input) {
    assertThat(RecursionAndDynamicProgramming.findMagicIndexWithBinarySearch(input), isIn(expected));
  }

  static class MagicIndexArgumentProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
      return Stream.of(
        Arguments.of(Collections.singletonList(7), new int[]{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13}),
        Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5, 6), new int[]{0, 1, 2, 3, 4, 5, 6}),
        Arguments.of(Collections.singletonList(-1), new int[]{1, 2, 3, 4, 5, 6}),
        Arguments.of(Collections.singletonList(2), new int[]{-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13})
      );
    }
  }

  @Test
  void tripleStep() {
    assertEquals(7, RecursionAndDynamicProgramming.jumpStep(4, MAX_JUMP_SIZE));
    assertEquals(927, RecursionAndDynamicProgramming.jumpStep(12, MAX_JUMP_SIZE));
  }

  @Test
  void robotInAGrid() {
    var pathInAGrid = RecursionAndDynamicProgramming.findPathInAGrid(grid);
    assertFalse(pathInAGrid.size() == 0, "There should be a valid path here.");
    verifyAllowedMoves(pathInAGrid);
  }

  @Test
  void testIsAtExit() {
    assertTrue(RecursionAndDynamicProgramming.isAtTheExit(Position.of(7, 7), grid));
    assertFalse(RecursionAndDynamicProgramming.isAtTheExit(Position.of(6, 7), grid));
    assertFalse(RecursionAndDynamicProgramming.isAtTheExit(Position.of(7, 6), grid));
    assertFalse(RecursionAndDynamicProgramming.isAtTheExit(Position.of(8, 7), grid));
    assertFalse(RecursionAndDynamicProgramming.isAtTheExit(Position.of(8, 8), grid));
  }

  @Test
  void canMoveTo() {
    assertTrue(RecursionAndDynamicProgramming.canMoveTo(Position.of(7, 7), grid));
    assertTrue(RecursionAndDynamicProgramming.canMoveTo(Position.of(6, 7), grid));
    assertTrue(RecursionAndDynamicProgramming.canMoveTo(Position.of(7, 6), grid));
    assertFalse(RecursionAndDynamicProgramming.canMoveTo(Position.of(2, 1), grid));
    assertFalse(RecursionAndDynamicProgramming.canMoveTo(Position.of(8, 7), grid));
    assertFalse(RecursionAndDynamicProgramming.canMoveTo(Position.of(8, 8), grid));
  }

  private void verifyAllowedMoves(List<Position> pathInAGrid) {
    for (var i = 1; i < pathInAGrid.size(); i++) {
      var currentStep = pathInAGrid.get(i);
      var previousStep = pathInAGrid.get(i - 1);

      var moveDown = currentStep.row - previousStep.row == 1;
      var moveRight = currentStep.col - previousStep.col == 1;

      assertFalse(moveDown && moveRight, "The robot should either move down or right, but not both!");
      assertTrue(moveDown || moveRight, "The robot should either move down or right!");
      assertTrue(currentStep.row - previousStep.row >= 0, "The robot shouldn't move up");
      assertTrue(currentStep.col - previousStep.col >= 0, "The robot shouldn't move left");
    }
  }
}
