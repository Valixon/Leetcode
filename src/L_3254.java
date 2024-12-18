import java.util.Arrays;

public class L_3254 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3)));
        System.out.println(Arrays.toString(resultsArray(new int[]{2, 2, 2, 2, 2}, 4)));
        System.out.println(Arrays.toString(resultsArray(new int[]{3, 2, 3, 2, 3, 2}, 2)));
    }


    public static int[] resultsArray(int[] nums, int k) {
        if (k==1)return nums;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            res[i] = nums[i + k - 1];
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] - 1 != nums[j - 1]) {
                    res[i] = -1;
                    break;
                }
            }
        }
        return res;
    }
}