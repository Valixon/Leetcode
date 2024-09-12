import java.util.Arrays;

public class L_645 {
    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 1})));
    }

    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int conf = 0;
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                conf = nums[i];
                break;
            }
        }
        sum = Arrays.stream(nums).sum();
        int x = (n * (n + 1)) / 2;
        return new int[]{conf, x - (sum - conf)};
    }
}