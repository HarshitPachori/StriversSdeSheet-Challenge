import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSumVariant2 {
    public static List<int[]> pairSumBrute(int[] arr, int s) {
        // Write your code here.
        Arrays.sort(arr);
        List<int[]> ans = new ArrayList<>();
        // HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum == s) {
                    ans.add(new int[] { Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j]) });
                }
            }
        }

        return ans;

    }
}
