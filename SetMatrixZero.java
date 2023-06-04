import java.util.ArrayList;

public class SetMatrixZero {
    // Brute force TC -> O(m*n*(m +n)) + O(m*n) SC -> O(1)
    public void setRow(ArrayList<ArrayList<Integer>> matrix, int m, int i) {
        for (int j = 0; j < m; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    public void setCol(ArrayList<ArrayList<Integer>> matrix, int n, int j) {
        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    public void setZeroesBrute(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // inserting -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    setRow(matrix, m, i);
                    setCol(matrix, n, j);
                }
            }
        }
        // inserting 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

    }

    // Better TC -> O(m*n) + O(m*n) = O(2*m*n) SC -> O(m+n)
    public void setZeroesBetter(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int row[] = new int[n];
        int col[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        // insert 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
    }

    // Optimal TC -> O(2*m*n) SC -> O(1)
    public void setZeroesOptimal(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int col0 = 1;
        // mark 1st row and 1st col
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark ith row
                    matrix.get(i).set(0, 0);

                    // mark jth col
                    if (j != 0) {
                        matrix.get(0).set(j, 0);
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        // mark row and col from [1,1] to [n-1,m-1]
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix.get(i).get(j) != 0) {
                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }

        // check mat[0][0] == 0 then set mat[0][j] = 0
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        // check col0 = 0 then set mat[i][0] = 0
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }
    }
}
