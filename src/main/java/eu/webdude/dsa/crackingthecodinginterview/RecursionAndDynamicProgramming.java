package eu.webdude.dsa.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

class RecursionAndDynamicProgramming {

  private static final int CELL_IS_FREE = 0;

  static int jumpStep(int n, int maxJumpSize) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    } else {
      return IntStream.rangeClosed(1, maxJumpSize)
        .map(i -> jumpStep(n - i, maxJumpSize))
        .sum();
    }
  }

  private static boolean findPathInAGrid(byte[][] grid, Position currentPosition, Deque<Position> path) {
    assert currentPosition != null;

    if (isAtTheExit(currentPosition, grid)
      || tryMove(currentPosition.down(), grid, path)
      || tryMove(currentPosition.left(), grid, path)) {

      path.push(currentPosition);
      return true;
    }

    return false;
  }

  private static boolean tryMove(Position position, byte[][] grid, Deque<Position> path) {
    return canMoveTo(position, grid) && findPathInAGrid(grid, position, path);
  }

  static boolean isAtTheExit(Position position, byte[][] grid) {
    return grid.length - 1 == position.row && grid[grid.length - 1].length - 1 == position.col;
  }

  private static boolean isInBounds(Position position, byte[][] grid) {
    return position.row < grid.length && (position.col < grid[position.row].length);
  }

  private static byte getValueAt(Position position, byte[][] grid) {
    return grid[position.row][position.col];
  }

  static boolean canMoveTo(Position position, byte[][] grid) {
    return isInBounds(position, grid) && getValueAt(position, grid) == CELL_IS_FREE;

  }

  static List<Position> findPathInAGrid(byte[][] grid) {
    LinkedList<Position> resultPath = new LinkedList<>();
    boolean pathInAGridIsFound = findPathInAGrid(grid, Position.of(0, 0), resultPath);

    if (pathInAGridIsFound) {
      return resultPath;
    } else {
      return new ArrayList<>();
    }
  }
}
