package eu.webdude.dsa.crackingthecodinginterview;

public class ArrayChallenges {
    public static int[][] rotateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int end = matrix.length - 1 - i;

            for (int j = i; j < end; j++) {
                int endOffset = matrix.length - 1 - j;
                int top = matrix[i][j];

                matrix[i][j] = matrix[endOffset][i];
                matrix[endOffset][i] = matrix[end][endOffset];
                matrix[end][endOffset] = matrix[j][end];
                matrix[j][end] = top;
            }
        }

        return matrix;
    }
}
