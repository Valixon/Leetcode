import java.util.Arrays;

public class L_198 {
    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob(new int[]{71, 55, 82, 55}));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        hisobla(nums, 0);
        hisobla(nums, 1);
        return Math.max(dp[0], dp[1]);
    }

    private static int hisobla(int[] nums, int index) {
        if (index >= nums.length) return 0;
        if (dp[index] != -1) return dp[index];
        if (index == nums.length - 1 || index == nums.length - 2) {
            dp[index] = nums[index];
            return nums[index];
        }
        dp[index] = nums[index];
        dp[index] += Math.max(hisobla(nums, index + 2), hisobla(nums, index + 3));
        return dp[index];
    }
}