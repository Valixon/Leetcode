public class L_279 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }


    public static int numSquares(int n) {
        double d = Math.sqrt(n);
        int x = (int) d;
        if (x == d) {
            return 1;
        }
        int[] dp = new int[n + 5];
        for (int i = 1; i <= x; i++) {
            dp[i * i] = 1;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;
        for (int i = 5; i <= n; i++) {
            x = (int) Math.sqrt(i);
            if (dp[i] == 1) {
                continue;
            }
            dp[i] = i;
            for (int j = 1; j <= x; j++) {
                int p = j * j;
                dp[i] = Math.min(dp[i - p] + dp[p], dp[i]);
            }
        }
        return dp[n];
    }
}
