package eu.webdude.dsa.projecteuler;

import java.util.function.BiFunction;
import java.util.function.Function;

class Grid {

  static int largestProduct(int[][] testData) {
    return genericSolve(testData, 4, (a, b) -> a * b, Math::max, Integer.MIN_VALUE);
  }

  static int largestSum(int[][] testData) {
    return genericSolve(testData, 4, Integer::sum, Math::max, Integer.MIN_VALUE);
  }

  static int smallestSum(int[][] testData) {
    return genericSolve(testData, 4, Integer::sum, Math::min, Integer.MAX_VALUE);
  }

  static int smallestProduct(int[][] testData) {
    return genericSolve(testData, 4, (a, b) -> a * b, Math::min, Integer.MAX_VALUE);
  }

  private static int genericSolve(int[][] input, int lineSize,
                                  BiFunction<Integer, Integer, Integer> operation,
                                  BiFunction<Integer, Integer, Integer> reduction,
                                  int accumulator) {

    for (var row = 0; row < input.length - lineSize; row++) {
      for (var col = 0; col < input[row].length - lineSize; col++) {
        if (col >= lineSize) {
          accumulator = reduction.apply(reduceLeftDiagonalLine(input, row, col, lineSize, operation), accumulator);
        }

        accumulator = reduction.apply(reduceVerticalLine(input, row, col, lineSize, operation), accumulator);
        accumulator = reduction.apply(reduceHorizontalLine(input, row, col, lineSize, operation), accumulator);
        accumulator = reduction.apply(reduceRightDiagonalLine(input, row, col, lineSize, operation), accumulator);
      }
    }

    return accumulator;
  }

  private static int reduceVerticalLine(int[][] input, int row, int col, int lineSize, BiFunction<Integer, Integer, Integer> operation) {
    return matrixReduce(input, row, col, lineSize, operation, i -> input[row + i][col]);
  }

  private static int reduceHorizontalLine(int[][] input, int row, int col, int lineSize, BiFunction<Integer, Integer, Integer> operation) {
    return matrixReduce(input, row, col, lineSize, operation, i -> input[row][col + i]);
  }

  private static int reduceRightDiagonalLine(int[][] input, int row, int col, int lineSize, BiFunction<Integer, Integer, Integer> operation) {
    return matrixReduce(input, row, col, lineSize, operation, i -> input[row + i][col + i]);
  }

  private static int reduceLeftDiagonalLine(int[][] input, int row, int col, int lineSize, BiFunction<Integer, Integer, Integer> operation) {
    return matrixReduce(input, row, col, lineSize, operation, i -> input[row + i][col - i]);
  }

  private static int matrixReduce(int[][] input, int row, int col, int lineSize, BiFunction<Integer, Integer, Integer> operation, Function<Integer, Integer> direction) {
    var accumulator = input[row][col];

    for (var i = 1; i < lineSize; i++) {
      accumulator = operation.apply(accumulator, direction.apply(i));
    }

    return accumulator;
  }
}
