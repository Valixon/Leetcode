public class L_3011 {
    public static void main(String[] args) {
        System.out.println(canSortArray(new int[]{8,4,2,30,15}));
    }

    public static boolean canSortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1] && Integer.bitCount(nums[i]) != Integer.bitCount(nums[i - 1])) return false;
        }
        return true;
    }
}