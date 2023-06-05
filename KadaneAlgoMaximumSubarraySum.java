public class KadaneAlgoMaximumSubarraySum {

    // brute TC -> O(n^3) SC -> O(1)
    public static long maxSubarraySumBrute(int[] arr, int n) {
        long maxSum = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // better TC -> O(n^2) SC -> O(1)
    public static long maxSubarraySumBetter(int[] arr, int n) {
        long maxSum = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // optimal TC -> O(n) SC -> O(1) kadane algo
    public static long maxSubarraySumOptimal(int[] arr, int n) {
        long maxSum = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}