public class L_2560 {

    public static void main(String[] args) {
        System.out.println(minCapability(new int[]{2, 3, 5, 9}, 2));
        System.out.println(minCapability(new int[]{2, 7, 9, 3, 1}, 2));
    }


    public static int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        for (int num : nums) {
            if (left > num) left = num;
            if (right < num) right = num;
        }
        while (left <= right) {
            int m = (left + right) / 2;
            if (bolami(nums, m, k)) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }
        return left;
    }

    private static boolean bolami(int[] nums, int m, int k) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= m) {
                x++;
                i++;
                if (x == k) return true;
            }
        }
        return false;
    }
}
