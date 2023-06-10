import java.util.ArrayList;

public class RotateMatrix {
    /*
     * i/p mat = [1 2 3] o/p mat = [7 4 1]
     * [4 5 6] [8 5 2]
     * [7 8 9] [9 6 3]
     */
    // brute TC -> O(n^2) SC -> O(n^2) for square matrix
    public static void rotateMatrixBy90DegreeBrute(ArrayList<ArrayList<Integer>> mat, int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> rotated = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated.get(j).set(n - i - 1, mat.get(i).get(j));
            }
        }
    }

    // Optimal TC -> O(n^2) SC -> O(1) for square matrix here find transpose then
    // reverse each row
    public static void rotateMatrixBy90DegreeOptimal(ArrayList<ArrayList<Integer>> mat, int n) {
        // Write your code here.
        // transposing
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat.get(i).get(j);
                mat.get(i).set(j, mat.get(j).get(i));
                mat.get(mat.get(j).set(i, temp));
            }
        }

        // reversing row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat.get(i).get(j);
                mat.get(i).set(j, mat.get(i).get(n - j - 1));
                mat.get(mat.get(i).set(n - j - 1, temp));
            }
        }
    }

    /*
     * i/p = [1 2 3] o\p = [4 1 2]
     * [4 5 6] [7 5 3]
     * [7 8 9] [8 9 6]
     */
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Write your code here.
        int u = 0;
        int d = n - 1;
        int l = 0;
        int r = m - 1;
        while (l < r && u < d) {
            int prev = mat.get(u + 1).get(l);
            for (int i = l; i <= r; i++) {
                int curr = mat.get(u).get(i);
                mat.get(u).set(i, prev);
                prev = curr;
            }
            u++;
            for (int i = u; i <= d; i++) {
                int curr = mat.get(i).get(r);
                mat.get(i).set(r, prev);
                prev = curr;
            }
            r--;
            for (int i = r; i >= l; i--) {
                int curr = mat.get(d).get(i);
                mat.get(d).set(i, prev);
                prev = curr;
            }
            d--;
            for (int i = d; i >= u; i--) {
                int curr = mat.get(i).get(l);
                mat.get(i).set(l, prev);
                prev = curr;
            }
            l++;
        }
    }
}
