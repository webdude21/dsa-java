package eu.webdude.dsa.crackingthecodinginterview;

import java.util.*;
import java.util.stream.IntStream;

class RecursionAndDynamicProgramming {

  private static final int CELL_IS_FREE = 0;

  static int tripleStep(int n) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    } else {
      return IntStream.rangeClosed(1, 3).map(i -> tripleStep(n - i)).sum();
    }
  }

  private static boolean findPathInAGrid(byte[][] grid, Deque<Position> path) {
    Position currentPosition = path.peek();
    assert currentPosition != null;

    if (isAtTheExit(currentPosition, grid)) {
      return true;
    }

    return tryMove(currentPosition.down(), grid, path) || tryMove(currentPosition.left(), grid, path);
  }

  private static boolean tryMove(Position position, byte[][] grid, Deque<Position> path) {
    if (canMoveTo(position, grid)) {
      path.push(position);
      return findPathInAGrid(grid, path);
    } else {
      path.removeLastOccurrence(position);
      return false;
    }
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
    Position startingPoint = Position.of(0, 0);
    LinkedList<Position> resultPath = new LinkedList<>(Collections.singletonList(startingPoint));
    boolean pathInAGridIsFound = findPathInAGrid(grid, resultPath);

    if (pathInAGridIsFound) {
      Collections.reverse(resultPath);
      return resultPath;
    } else {
      return new ArrayList<>();
    }
  }
}
