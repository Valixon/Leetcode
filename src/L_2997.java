public class L_2997 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2, 1, 3, 4}, 1));
//        System.out.println(minOperations(new int[]{2, 1, 2, 4}, 1));
//        System.out.println(minOperations(new int[]{1, 2, 4, 6}, 1));
    }

    public static int minOperations(int[] nums, int k) {
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            x = x ^ nums[i];
        }
        return Integer.bitCount(x ^ k);
    }
}
