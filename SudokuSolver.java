public class SudokuSolver {
    public static boolean isValid(int matrix[][], int row, int col, int k) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] == k || matrix[i][col] == k)
                return false;
        }
        int srow = row / 3 * 3;
        int scol = col / 3 * 3;
        int n = srow + 3;
        int m = scol + 3;
        for (int i = srow; i < n; i++) {
            for (int j = scol; j < m; j++) {
                if (matrix[i][j] == k)
                    return false;
            }
        }
        return true;
    }

    // TC -> O(9^(n*n)) SC -> O(1)
    public static boolean isItSudoku(int matrix[][]) {

        // Write your code here.
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k <= 9; k++) {
                        if (isValid(matrix, i, j, k)) {
                            matrix[i][j] = k;
                            if (isItSudoku(matrix)) {
                                return true;
                            } else {
                                matrix[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
