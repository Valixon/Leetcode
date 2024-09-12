public class L_136 {

    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 3, 1, 6, 7}));
        System.out.println(singleNumber(new int[]{1, 1, 1, 1, 1}));
    }


    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}