public class GraphColoring {
    // 1-based indexing
    // TC -> O(n^m)
    // SC -> O(n)
     public static boolean isSafe(int i, int mat[][], int color[], int clr) {
        for (int j = 0; j < mat.length; j++) {
            if (i != j && mat[i][j] == 1 && color[j] == clr) {
                return false;
            }
        }
        return true;
    }

    public static boolean solve(int i, int[][] mat, int n, int m, int[] color) {
        if (i == n)
            return true;
        for (int j = 1; j <= m; j++) {
            if (isSafe(i, mat, color, j)) {
                color[i] = j;
                if (solve(i + 1, mat, n, m, color)) {
                    return true;
                }
                color[i] = 0;
            }
        }
        return false;
    }

    public static String graphColoring(int[][] mat, int m) {
        // Write your code here
        int color[] = new int[mat.length];
        for (int i = 0; i < mat.length; i++)
            color[i] = 0;
        if (solve(0, mat, mat.length, m, color)) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
