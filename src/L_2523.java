import java.math.BigDecimal;
import java.util.Arrays;

public class L_2523 {
    private static byte[] bytes;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestPrimes(10, 19)));
        System.out.println(Arrays.toString(closestPrimes(4, 7)));
    }


    public static int[] closestPrimes(int left, int right) {
        System.out.println(new BigDecimal("22337.72 UZS"));
        int n = 1000000;
        boolean[] prime = new boolean[n + 1];
        for (int p = 2; p * p <= n; p++) {
            if (!prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = true;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (!prime[i]) {
                left = i;
                break;
            }
        }
        int a = -1;
        int b = -1;
        for (int i = left + 2; i <= right; i += 2) {
            if (!prime[i]) {
                if (min > i - left) {
                    min = i - left;
                    a = left;
                    b = i;
                }
                left = i;
            }
        }
        return new int[]{a, b};
    }
}
