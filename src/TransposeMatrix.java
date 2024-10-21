import java.util.Arrays;

public class TransposeMatrix {

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i].length != cols) {
                    throw new IllegalArgumentException("Irregular matrix");
                }
                transposedMatrix [j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public static void main(String... args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
        };

        System.out.println(Arrays.deepToString(transposeMatrix(matrix)));
    }

}
