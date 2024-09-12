import java.util.Arrays;

public class L_995 {
    public static void main(String[] args) {
        System.out.println(minKBitFlips(new int[]{0, 1, 0}, 1));
        System.out.println(minKBitFlips(new int[]{1, 1, 0}, 2));
        System.out.println(minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));
    }


    public static int minKBitFlips(int[] nums, int k) {
        int left = 0;
        int n = nums.length;
        int count = 0;
        while (left <= n - k) {
            if (nums[left] == 1) {
                left++;
            } else {
                if (left + 1 <= n - k && nums[left + 1] == 1) {
                    nums[left + k] ^= 1;
                    count += 2;
                    left++;
                    continue;
                }
                for (int i = left; i < left + k; i++) {
                    nums[i] ^= 1;
                }
                count++;
            }
        }
        for (int i = left; i < n; i++) {
            if (nums[i] == 0) return -1;
        }
        System.out.println(Arrays.toString(nums));
        return count;
    }
}