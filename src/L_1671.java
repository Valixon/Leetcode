import java.util.Arrays;

public class L_1671 {
    public static void main(String[] args) {
        System.out.println(minimumMountainRemovals(new int[]{100, 92, 89, 77, 74, 66, 64, 66, 64}));
        System.out.println(minimumMountainRemovals(new int[]{2, 1, 1, 5, 6, 2, 3, 1}));
    }

    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dpLeft[i] = Math.max(dpLeft[i], dpLeft[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    dpRight[i] = Math.max(dpRight[i], dpRight[j] + 1);
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (dpLeft[i] * dpRight[i] == 0) continue;
            res = Math.max(res, dpLeft[i] + dpRight[i] + 1);
        }
        return n - res;
    }

}