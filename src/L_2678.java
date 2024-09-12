public class L_2678 {

    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{0, 1, 0, 0, 1, 0, 0, 0, 1}));
        System.out.println(minSwaps(new int[]{0, 1, 0, 1, 1, 0, 0}));
        System.out.println(minSwaps(new int[]{1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0}));
    }

    public static int minSwaps(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int num : nums) {
            count += num;
        }
        int a = 0;
        for (int i = 0; i < count; i++) {
            if (nums[i] == 0) a++;

        }
        int min = a;
        for (int i = 1; i < n; i++) {
            a += (nums[i - 1] - nums[(i + count - 1) % n]);
            min = Math.min(min, a);
        }
        return min;
    }
}
