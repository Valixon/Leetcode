public class L_1043 {
    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
        System.out.println(maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
        System.out.println(maxSumAfterPartitioning(new int[]{1}, 1));
    }

    //    1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3
//    4, 4, 7, 7, 7, 9, 9, 9, 9, 9, 9
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int lmax = 0;
            for (int j = 1; j <= Math.min(k, i); j++) {
                int max = 0;
                for (int l = i - 1; l >= i - j; l--) {
                    max = Math.max(max, arr[l]);
                }
                lmax = Math.max(dp[i - j] + (max * j), lmax);
            }
            dp[i] = lmax;
        }
        return dp[n];
    }
}
