public class L_2290 {

    public static void main(String[] args) {
        System.out.println(minimumObstacles(new int[][]{{0, 1, 1}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(minimumObstacles(new int[][]{{0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}}));
    }


    public static int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int min = Integer.MAX_VALUE;
                if (dp[i - 1][j] > 0) {
                    min = dp[i - 1][j];
                }
                if (dp[i + 1][j] > 0) {
                    min = Math.min(dp[i + 1][j], min);
                }
                if (dp[i][j - 1] > 0) {
                    min = Math.min(dp[i][j - 1], min);
                }
                if (dp[i][j + 1] > 0) {
                    min = Math.min(dp[i][j + 1], min);
                }
                if (min == Integer.MAX_VALUE) min = 0;
                dp[i][j] = min + grid[i - 1][j - 1];
            }
        }
//        for (int i = 0; i < n + 2; i++) {
//            for (int j = 0; j < m + 2; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        boolean bor = true;
        while (bor) {
            bor = false;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    int min = Integer.MAX_VALUE;
                    if (dp[i - 1][j] > -1) {
                        min = dp[i - 1][j];
                    }
                    if (dp[i + 1][j] > -1) {
                        min = Math.min(dp[i + 1][j], min);
                    }
                    if (dp[i][j - 1] > -1) {
                        min = Math.min(dp[i][j - 1], min);
                    }
                    if (dp[i][j + 1] > -1) {
                        min = Math.min(dp[i][j + 1], min);
                    }
                    if (min == Integer.MAX_VALUE) min = 0;
                    min += grid[i - 1][j - 1];
                    if (min < dp[i][j]) {
                        bor = true;
                        dp[i][j] = min;
                    }
                }
            }
            for (int i = n; i >= 1; i--) {
                for (int j = 1; j <= m; j++) {
                    int min = Integer.MAX_VALUE;
                    if (dp[i - 1][j] > -1) {
                        min = dp[i - 1][j];
                    }
                    if (dp[i + 1][j] > -1) {
                        min = Math.min(dp[i + 1][j], min);
                    }
                    if (dp[i][j - 1] > -1) {
                        min = Math.min(dp[i][j - 1], min);
                    }
                    if (dp[i][j + 1] > -1) {
                        min = Math.min(dp[i][j + 1], min);
                    }
                    if (min == Integer.MAX_VALUE) min = 0;
                    min += grid[i - 1][j - 1];
                    if (min < dp[i][j]) {
                        bor = true;
                        dp[i][j] = min;
                    }
                }
            }
            for (int j = 1; j <= m; j++) {
                for (int i = 1; i <= n; i++) {
                    int min = Integer.MAX_VALUE;
                    if (dp[i - 1][j] > -1) {
                        min = dp[i - 1][j];
                    }
                    if (dp[i + 1][j] > -1) {
                        min = Math.min(dp[i + 1][j], min);
                    }
                    if (dp[i][j - 1] > -1) {
                        min = Math.min(dp[i][j - 1], min);
                    }
                    if (dp[i][j + 1] > -1) {
                        min = Math.min(dp[i][j + 1], min);
                    }
                    if (min == Integer.MAX_VALUE) min = 0;
                    min += grid[i - 1][j - 1];
                    if (min < dp[i][j]) {
                        bor = true;
                        dp[i][j] = min;
                    }
                }
            }
            for (int j = m; j >= 1; j--) {
                for (int i = 1; i <= n; i++) {
                    int min = Integer.MAX_VALUE;
                    if (dp[i - 1][j] > -1) {
                        min = dp[i - 1][j];
                    }
                    if (dp[i + 1][j] > -1) {
                        min = Math.min(dp[i + 1][j], min);
                    }
                    if (dp[i][j - 1] > -1) {
                        min = Math.min(dp[i][j - 1], min);
                    }
                    if (dp[i][j + 1] > -1) {
                        min = Math.min(dp[i][j + 1], min);
                    }
                    if (min == Integer.MAX_VALUE) min = 0;
                    min += grid[i - 1][j - 1];
                    if (min < dp[i][j]) {
                        bor = true;
                        dp[i][j] = min;
                    }
                }
            }
        }

//        for (int i = 0; i < n + 2; i++) {
//            for (int j = 0; j < m + 2; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[n][m];
    }
}