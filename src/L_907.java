import java.util.Stack;

public class L_907 {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println(sumSubarrayMins(new int[]{11, 81, 94, 43, 3}));
        System.out.println(sumSubarrayMins(new int[]{71,55,82,55}));
    }

    public static int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int left = i - 1;
            while (left >= 0 && arr[left] > arr[i]) {
                left--;
            }

            int right = i + 1;
            while (right < n && arr[right] >= arr[i]) {
                right++;
            }

            long contribution = ((long) (i - left) * (right - i) % MOD) * arr[i] % MOD;
            sum = (sum + contribution) % MOD;
        }

        return (int) sum;
    }


}