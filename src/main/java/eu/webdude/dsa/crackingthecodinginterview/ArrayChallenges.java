package eu.webdude.dsa.crackingthecodinginterview;

public class ArrayChallenges {
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
}
