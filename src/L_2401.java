public class L_2401 {

    public static void main(String[] args) {
        System.out.println(longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
        System.out.println(longestNiceSubarray(new int[]{3, 1, 5, 11, 13}));
    }


    public static int longestNiceSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int res = 0;
        int max = 1;
        int n = nums.length;
        while (right < n) {
            if ((res & nums[right]) == 0) {
                res = res | nums[right++];
            } else {
                max = Math.max(max, right - left);
                res = res ^ nums[left++];
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
}

