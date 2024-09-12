import java.util.Arrays;

public class L_2971 {
    private static byte[] bytes;

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{5, 5, 5}));
        System.out.println(largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3}));
        System.out.println(largestPerimeter(new int[]{5, 5, 50}));
    }


    public static long largestPerimeter(int[] nums) {
        long s = 0;
        for (int num : nums) {
            s += num;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int p = nums[i];
            if (p < s - p) {
                return s;
            }
            s = s - p;
        }
        return -1;
    }
}
