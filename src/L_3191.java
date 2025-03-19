public class L_3191 {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{0, 1, 1, 1, 0, 0}));
        System.out.println(minOperations(new int[]{0, 1, 1, 1}));
    }


    public static int minOperations(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i + 2 >= nums.length) {
                    return -1;
                } else {
                    res++;
                    nums[i] = 1;
                    nums[i + 1] = nums[i + 1] ^ 1;
                    nums[i + 2] = nums[i + 2] ^ 1;
                }
            }
        }
        return res;
    }
}

