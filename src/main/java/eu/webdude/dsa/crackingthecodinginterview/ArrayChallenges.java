package eu.webdude.dsa.crackingthecodinginterview;

import java.util.ArrayList;

class ArrayChallenges {

  public static int[][] rotateMatrix(int[][] matrix) {
    for (var i = 0; i < matrix.length / 2; i++) {
      var end = matrix.length - 1 - i;

      for (var j = i; j < end; j++) {
        var endOffset = matrix.length - 1 - j;
        var top = matrix[i][j];

        matrix[i][j] = matrix[endOffset][i];
        matrix[endOffset][i] = matrix[end][endOffset];
        matrix[end][endOffset] = matrix[j][end];
        matrix[j][end] = top;
      }
    }

    return matrix;
  }

  public static int[][] zeroArray(int[][] input) {
    var zeroCords = new ArrayList<Tuple2<Integer, Integer>>();

    for (var x = 0; x < input.length; x++) {
      for (var y = 0; y < input.length; y++) {
        if (input[x][y] == 0) {
          zeroCords.add(new Tuple2<>(x, y));
        }
      }
    }

    zeroCords.forEach(coordinates -> zeroLines(input, coordinates));

    return input;
  }

  private static void zeroLines(int[][] input, Tuple2<Integer, Integer> coordinates) {
    for (int i = 0; i < input.length; i++) {
      input[coordinates.first][i] = 0;
      input[i][coordinates.second] = 0;
    }
  }

  public static void printMatrix(int[][] matrix) {
    StringBuilder sb = new StringBuilder();

    for (int[] aMatrix : matrix) {
      sb.append(System.lineSeparator());
      for (int j = 0; j < matrix.length; j++) {
        sb.append("[").append(aMatrix[j]).append("]");
      }
    }

    sb.append(System.lineSeparator());

    System.out.println(sb.toString());
  }
}
