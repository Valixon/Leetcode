import java.util.Arrays;

public class L_238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));

    }


    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] chap = new int[n];
        int[] ong = new int[n];
        chap[0] = nums[0];
        ong[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            chap[i] = chap[i - 1] * nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            ong[i] = ong[i + 1] * nums[i];
        }
        int[] ans = new int[n];
        ans[0] = ong[1];
        ans[n - 1] = chap[n - 2];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = chap[i - 1] * ong[i + 1];
        }
        return ans;
    }
}