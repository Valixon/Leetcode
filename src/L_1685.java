import java.util.Arrays;

public class L_1685 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(new int[]{1, 4, 6, 8, 10})));
    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[] res = new int[n];
        res[0] = sum - (n * nums[0]);
        int ayirma = 0, su = res[0];
        for (int i = 1; i < n; i++) {
            ayirma = nums[i] - nums[i - 1];
            if (ayirma == 0) {
                res[i] = su;
                continue;
            }
            su = su + (2 * i - n) * ayirma;
            res[i] = su;
        }
        return res;
    }
}