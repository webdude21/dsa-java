package eu.webdude.dsa.crackingthecodinginterview;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayChallengesTest {

    @Test
    public void rotateMatrixOfFive() {
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
    public void rotateMatrixOfThree() {
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