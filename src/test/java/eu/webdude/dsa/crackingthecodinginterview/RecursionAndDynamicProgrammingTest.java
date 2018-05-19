package eu.webdude.dsa.crackingthecodinginterview;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecursionAndDynamicProgrammingTest {

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

  @Test
  void tripleStep() {
    assertEquals(7, RecursionAndDynamicProgramming.tripleStep(4));
    assertEquals(927, RecursionAndDynamicProgramming.tripleStep(12));
  }

  @Test
  void robotInAGrid() {
    List<Position> pathInAGrid = RecursionAndDynamicProgramming.findPathInAGrid(grid);
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
    for (int i = 1; i < pathInAGrid.size(); i++) {
      Position currentStep = pathInAGrid.get(i);
      Position previousStep = pathInAGrid.get(i - 1);

      boolean moveDown = currentStep.row - previousStep.row == 1;
      boolean moveRight = currentStep.col - previousStep.col == 1;

      assertFalse(moveDown && moveRight, "The robot should either move down or right, but not both!");
      assertTrue(moveDown || moveRight, "The robot should either move down or right!");
      assertTrue(currentStep.row - previousStep.row >= 0, "The robot shouldn't move up");
      assertTrue(currentStep.col - previousStep.col >= 0, "The robot shouldn't move left");
    }
  }
}
