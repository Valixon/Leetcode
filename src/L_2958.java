import java.util.HashMap;
import java.util.Map;

public class L_2958 {
    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
        System.out.println(maxSubarrayLength(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1));
        System.out.println(maxSubarrayLength(new int[]{5, 5, 5, 5, 5, 5, 5}, 4));
        System.out.println(maxSubarrayLength(new int[]{5, 5, 5, 5, 5, 5, 5}, 1));
    }


    public static int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        int right = k - 1;
        int max = (right - left) + 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = left; i <= right; i++) {
            Integer rr = map.get(nums[i]);
            if (rr != null) {
                map.put(nums[i], ++rr);
            } else {
                map.put(nums[i], 1);
            }
        }
        right++;
        boolean salom = false;
        while (right < nums.length) {
            Integer rr = map.get(nums[right]);
            if (rr != null) {
                rr++;
                map.put(nums[right], rr);
            } else {
                map.put(nums[right], 1);
                rr = 1;
            }
            right++;
            if (salom && rr <= k) {
                max = (right - left);
                continue;
            }
            for (Integer i : map.keySet()) {
                if (map.get(i) > k) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    left++;
                    salom = false;
                    break;
                } else {
                    salom = true;
                }
            }
            max = (right - left);
        }
        return max;
    }
}
