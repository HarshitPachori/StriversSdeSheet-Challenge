import java.util.ArrayList;

public class NQueens {

    public static ArrayList<Integer>cnvList(int [][]board, int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    list.add(board[i][j]);
                }
        }
        // System.out.println("list " + list);
        return list;
            }
             public static void solve(int col, ArrayList<ArrayList<Integer>> ans, int [][] board, boolean[] leftRow,
                    boolean[] lowDiag, boolean[] upDiag, int n) {
                if (col == n) {
                    ans.add(cnvList(board,n));
                    return;
                }
                for (int row = 0; row < n; row++) {
                    if (!leftRow[row] && !lowDiag[row + col] && !upDiag[col - row + n]) {
                        board[row][col] = 1;
                        leftRow[row] = true;
                        lowDiag[row + col] = true;
                        upDiag[col - row + n] = true;
                        solve(col + 1, ans, board, leftRow, lowDiag, upDiag, n);
                        board[row][col] = 0;
                        leftRow[row] = false;
                        lowDiag[row + col] = false;
                        upDiag[col - row + n] = false;
                    }
                }
            }
        
            public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
                ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
                boolean leftRow[] = new boolean[n];
                boolean lowDiag[] = new boolean[2 * n];
                boolean upDiag[] = new boolean[2 * n];
                int board[][] = new int[n][n];
                for (int i = 0; i < board.length; i++) {
                   for(int j=0;j<board[0].length;j++){
                       board[i][j] = 0;
                   }
                }
                solve(0, ans, board, leftRow, lowDiag, upDiag, n);
                return ans;
            }

            // TC -> O(n! * n)
            // SC -> O(n)
}
