import java.util.Arrays;

public class L_2460 {
    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
    }

    public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == 0) continue;
            if (nums[i] == nums[i + 1]) {
                nums[i + 1] = 0;
                res[index++] = nums[i] * 2;
                i++;
            } else {
                res[index++] = nums[i];
            }
        }
        if (nums[n - 1] != 0) {
            res[index] = nums[n - 1];
        }

        return res;
    }
}