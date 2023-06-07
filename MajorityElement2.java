import java.util.ArrayList;
import java.util.HashMap;

public class MajorityElement2 {

    // TC -> O(n^2) SC -> O(1)
    public static ArrayList<Integer> majorityElementIIBrute(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (ans.size() == 0 || ans.get(0) != arr.get(i)) {
                int count = 0;
                for (int j = 0; j < arr.size(); j++) {
                    if (arr.get(i) == arr.get(j)) {
                        count++;
                    }
                }
                if (count > Math.floorDiv(arr.size(), 3)) {
                    ans.add(arr.get(i));
                }
            }
            if (ans.size() == 2)
                break;
        }
        return ans;
    }

    // TC -> O(nlogn) SC -> O(n)
    public static ArrayList<Integer> majorityElementIIBetter(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int mini = Math.floorDiv(arr.size(), 3) + 1;
        for (int i = 0; i < arr.size(); i++) {
            map.put(arr.get(i), map.get(arr.get(i)) + 1);
            if (map.get(arr.get(i)) == mini) {
                ans.add(arr.get(i));
            }
            if (ans.size() == 2)
                break;
        }
        return ans;
    }

    // TC -> O(n) SC -> O(1) Extended Moore's Vote Algorithm
    public static ArrayList<Integer> Optimal(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt1 = 0;
        int cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if (cnt1 == 0 && ele2 != arr.get(i)) {
                cnt1 = 1;
                ele1 = arr.get(i);
            } else if (cnt2 == 0 && ele1 != arr.get(i)) {
                cnt2 = 1;
                ele2 = arr.get(i);
            } else if (ele1 == arr.get(i)) {
                cnt1++;
            } else if (ele2 == arr.get(i)) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == ele1)
                cnt1++;
            if (arr.get(i) == ele2)
                cnt2++;
        }

        // the least occurance
        int mini = (int) (arr.size() / 3) + 1;
        if (cnt1 >= mini)
            ans.add(ele1);
        if (cnt2 >= mini)
            ans.add(ele2);

        return ans;
    }
}
