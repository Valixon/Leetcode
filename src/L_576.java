public class L_576 {

    public static void main(String[] args) {
        System.out.println(findPaths(36, 5, 50, 15, 3));
        System.out.println(findPaths(3, 4, 50, 1, 1));
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long res = 0;
        long[][] dp = new long[m + 2][n + 2];
        long[][] temp_dp = new long[m + 2][n + 2];
        temp_dp[startRow + 1][startColumn + 1] = 1;
        while (maxMove > 0) {
            maxMove--;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (temp_dp[i][j] != 0) {
                        long x = temp_dp[i][j] % 1000000007;
                        dp[i - 1][j] += x;
                        dp[i + 1][j] += x;
                        dp[i][j - 1] += x;
                        dp[i][j + 1] += x;
                    }
                }
            }
            for (int i = 1; i <= m; i++) {
                res += (dp[i][0]);
                res += (dp[i][n + 1]);
                res %= 1000000007;

            }
            for (int i = 1; i <= n; i++) {
                res += (dp[0][i]);
                res += (dp[m + 1][i]);
                res %= 1000000007;
            }
            res %= 1000000007;
            temp_dp = dp;
            dp = new long[m + 2][n + 2];
        }

        return (int) (res % 1000000007);
    }
}
