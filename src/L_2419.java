public class L_2419 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 3, 4, 8}));
    }

    public static int longestSubarray(int[] nums) {
        int max = 0;
        for (int num : nums)
            if (num > max) max = num;
        int res = 0;
        int javob = 0;
        for (int num : nums) {
            if (max == num) {
                res++;
                if (res > javob) javob = res;
            } else {
                res = 0;
            }
        }
        return javob;
    }
}