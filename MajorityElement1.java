import java.util.HashMap;
import java.util.Map;

public class MajorityElement1 {
    // n/2
    // TC -> O(n^2) SC -> O(1)
    public static int findMajorityBrute(int[] arr, int n) {
        // Write your code here.
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j])
                    cnt++;
            }
            if (cnt > n / 2) {
                return arr[i];
            }
        }
        return -1;
    }

    // TC -> O(nlogn + n) SC -> O(n)
    public static int findMajorityBetter(int[] arr, int n) {
        // Write your code here.
        HashMap<Integer, Integer> map = new HashMap<>();
        // O(nlogn)
        for (int i = 0; i < n; i++) {
            // O(logn)
            map.put(arr[i], map.get(arr[i]) + 1);
        }

        // O(n)
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > n / 2) {
                return it.getKey();
            }
        }
        return -1;
    }

    // TC -> O(2n) SC -> O(1) Moore's Voting algorithm
    public static int findMajorityOptimal(int[] arr, int n) {
        // Write your code here.
        int count = 0; // taking count of element
        int element = 0; // store element
        // case 1: cnt = 0 => ele = arr[i] cnt = 1 , case 2: ele = arr[i] => cnt++ ,
        // case 3:
        // arr[i] != ele => cnt--
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = arr[i];
                count = 1;
            } else if (arr[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        // now in ele the number is stored which is in majority we have to check for it
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == element) {
                cnt++;
            }
        }
        if (cnt > n / 2) {
            return element;
        }
        return -1;
    }
}
