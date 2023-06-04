import java.util.ArrayList;

public class SearchInA2DMatrix {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int n = mat.size();
        int m = mat.get(0).size();
        int start = 0;
        int end = (m * n) - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int currEle = mat.get(mid / m).get(mid % m);
            if (currEle == target) {
                return true;
            } else if (currEle < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    // TC -> O(log(m*n))
    // SC -> O(1) 
}
