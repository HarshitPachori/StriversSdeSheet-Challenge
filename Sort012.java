public class Sort012 {

    // brute force Sort function TC -> O(nlogn) SC -> O(1)

    // better approach TC -> O(n) + O(n) SC -> O(1)
    public static void sort012Bettter(int[] arr) {
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        // finding the counts of the numbers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                cnt0++;
            } else if (arr[i] == 1) {
                cnt1++;
            } else if (arr[i] == 2) {
                cnt2++;
            }
        }
        int n = cnt0;
        int m = cnt0 + cnt1;
        int l = cnt0 + cnt1 + cnt2;

        // inserting the numbers with count frequency in the array
        for (int i = 0; i < n; i++) {
            arr[i] = 0;
        }
        for (int i = n; i < m; i++) {
            arr[i] = 1;
        }
        for (int i = m; i < l; i++) {
            arr[i] = 2;
        }
    }

    // optimal dutch national glag algo or 3-pointers algo TC -> O(n) SC -> O(1)
    public static void sort012Optimal(int[] arr) {
        int start = 0;
        int mid = 0;
        int end = arr.length - 1;
        while (mid <= end) {
            if (arr[mid] == 0) {
                int temp = arr[start];
                arr[start] = arr[mid];
                arr[mid] = temp;
                start++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[end];
                arr[end] = temp;
                end--;
            }
        }
    }
}
