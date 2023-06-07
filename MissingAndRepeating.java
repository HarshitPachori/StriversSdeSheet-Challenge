import java.util.ArrayList;

public class MissingAndRepeating {

    // TC -> O(n^2) SC -> O(1)
    public static int[] missingAndRepeatingBrute(ArrayList<Integer> arr, int n) {
        int repeating = -1;
        int missing = -1;
        for (int i = 1; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr.get(j) == i)
                    count++;
            }
            if (count == 2)
                repeating = i;
            else if (count == 0)
                missing = i;
            if (repeating == -1 && missing == -1)
                break;
        }
        int ans[] = { repeating, missing };
        return ans;
    }

    // TC -> O(2n) SC -> O(n)
    public static int[] missingAndRepeatingBetter(ArrayList<Integer> arr, int n) {
        int missing = -1;
        int repeating = -1;
        int hash[] = new int[n];
        for (int i = 0; i < n; i++) {
            hash[arr.get(i)]++;
        }
        for (int i = 0; i < n; i++) {
            if (hash[i] == 0)
                missing = i;
            else if (hash[i] == 2)
                repeating = i;
        }
        int ans[] = { repeating, missing };
        return ans;

    }

    // TC -> O(n) SC -> O(1)
    public static int[] missingAndRepeatingOptimal(ArrayList<Integer> arr, int n) {
        long sn = ((long) n * ((long) n + 1)) / 2;
        long s2n = ((long) n * ((long) n + 1) * (2 * (long) n + 1)) / 6;
        long s = 0;
        long s2 = 0;
        for (int i = 0; i < n; i++) {
            s += arr.get(i);
            s2 += arr.get(i) * arr.get(i);
        }
        long val1 = s - sn; // s - sn = x - y
        long val2 = s2 - s2n; // s2 - s2n = x2 - y2 = (x + y)(x - y)
        val2 = val2 / val1; // = x + y
        long x = (val1 + val2) / 2;
        long y = val2 - x;
        int ans[] = { (int) x, (int) y };
        return ans;
    }

}
