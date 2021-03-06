package eu.webdude.dsa.crackingthecodinginterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayChallengesTest {

  @Test
  void rotateMatrixOfFive() {
    var input = generateMatrix(5);
    var expected = new int[5][];

    expected[0] = new int[]{0, 0, 0, 0, 0};
    expected[1] = new int[]{1, 1, 1, 1, 1};
    expected[2] = new int[]{2, 2, 2, 2, 2};
    expected[3] = new int[]{3, 3, 3, 3, 3};
    expected[4] = new int[]{4, 4, 4, 4, 4};

    assertArrayEquals(expected, ArrayChallenges.rotateMatrix(input));
  }

  @Test
  void zeroMatrixTest() {
    var input = new int[5][];

    input[0] = new int[]{1, 2, 4, 9, 7};
    input[1] = new int[]{3, 1, 1, 1, 1};
    input[2] = new int[]{2, 2, 0, 2, 2};
    input[3] = new int[]{3, 3, 3, 3, 3};
    input[4] = new int[]{4, 0, 4, 4, 4};

    var expected = new int[5][];

    expected[0] = new int[]{1, 0, 0, 9, 7};
    expected[1] = new int[]{3, 0, 0, 1, 1};
    expected[2] = new int[]{0, 0, 0, 0, 0};
    expected[3] = new int[]{3, 0, 0, 3, 3};
    expected[4] = new int[]{0, 0, 0, 0, 0};

    assertArrayEquals(expected, ArrayChallenges.zeroArray(input));
  }

  @Test
  void rotateMatrixOfThree() {
    var input = generateMatrix(3);
    var expected = new int[3][];

    expected[0] = new int[]{0, 0, 0};
    expected[1] = new int[]{1, 1, 1};
    expected[2] = new int[]{2, 2, 2};

    assertArrayEquals(expected, ArrayChallenges.rotateMatrix(input));
  }

  private int[][] generateMatrix(int size) {
    var result = new int[size][];

    for (var i = 0; i < size; i++) {
      result[i] = new int[size];

      for (var j = 0; j < size; j++) {
        result[i][j] = j;
      }
    }

    return result;
  }
}
