import java.util.Arrays;

public class L_300 {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS2(new int[]{10, 9, 2, 5, 3, 7, 101, 18, 1}));
        System.out.println(lengthOfLIS2(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS2(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }


    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            int y = res[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > x) {
                    y = Math.max(res[j], y);
                }
                if (nums[j] - 1 == x) break;
            }
            y++;
            res[i] = y;
        }
        Arrays.sort(res);
        return res[n - 1];
    }

    public static int lengthOfLIS2(int[] nums) {

        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            System.out.println(i + " " + len + " " + x);
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            System.out.println(Arrays.toString(dp));
            if (i == len) len++;

        }

        return len;
    }
}