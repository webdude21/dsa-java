package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GridWalkTest {

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
  void robotInAGrid() {
    var pathInAGrid = GridWalk.findPathInAGrid(grid);
    assertFalse(pathInAGrid.size() == 0, "There should be a valid path here.");
    verifyAllowedMoves(pathInAGrid);
  }

  @Test
  void testIsAtExit() {
    assertTrue(GridWalk.isAtTheExit(Position.of(7, 7), grid));
    assertFalse(GridWalk.isAtTheExit(Position.of(6, 7), grid));
    assertFalse(GridWalk.isAtTheExit(Position.of(7, 6), grid));
    assertFalse(GridWalk.isAtTheExit(Position.of(8, 7), grid));
    assertFalse(GridWalk.isAtTheExit(Position.of(8, 8), grid));
  }

  @Test
  void canMoveTo() {
    assertTrue(GridWalk.canMoveTo(Position.of(7, 7), grid));
    assertTrue(GridWalk.canMoveTo(Position.of(6, 7), grid));
    assertTrue(GridWalk.canMoveTo(Position.of(7, 6), grid));
    assertFalse(GridWalk.canMoveTo(Position.of(2, 1), grid));
    assertFalse(GridWalk.canMoveTo(Position.of(8, 7), grid));
    assertFalse(GridWalk.canMoveTo(Position.of(8, 8), grid));
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
