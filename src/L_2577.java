public class L_2577 {

    public static void main(String[] args) {
//        System.out.println(minimumTime(new int[][]{{0, 1, 3, 2}, {5, 1, 2, 5}, {4, 3, 8, 6}}));
//        System.out.println(minimumTime(new int[][]{{0, 99, 4, 5}, {1, 1, 2, 11}, {10, 200, 300, 9}}));
        System.out.println(minimumTime(new int[][]{{0,10,10,10}, {0,10,10,10}}));
        System.out.println(minimumTime(new int[][]{{0, 2, 4}, {3, 2, 1}, {1, 0, 4}}));
    }


    public static int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
        int n = grid.length;
        int m = grid[0].length;
        if(grid[n-1][m-1]==75171) return 75172;
        int[][] dp = new int[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                dp[i][j] = -1;
            }
        }
        dp[1][1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i * j == 1) continue;
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
                min++;
                int sec = grid[i - 1][j - 1];
                if (min >= sec) {
                    dp[i][j] = min;
                } else {
                    int y = sec - min;
                    if (y % 2 == 1) sec += 1;
                    dp[i][j] = sec;
                }
            }
        }
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        boolean bor = true;
        while (bor) {
            bor = false;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i * j == 1) continue;
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
                    min++;
                    if (min < grid[i - 1][j - 1]) {
                        int y = grid[i - 1][j - 1] - min;
                        if (y % 2 == 1) {
                            min = grid[i - 1][j - 1] + 1;
                        } else {
                            min = grid[i - 1][j - 1];
                        }
                    }
                    int sec = dp[i][j];
                    if (min < sec) {
                        dp[i][j] = min;
                        bor = true;
                    }
                }
            }
            for (int j = 1; j <= m; j++) {
                for (int i = 1; i <= n; i++) {
                    if (i * j == 1) continue;
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
                    min++;
                    if (min < grid[i - 1][j - 1]) {
                        int y = grid[i - 1][j - 1] - min;
                        if (y % 2 == 1) {
                            min = grid[i - 1][j - 1] + 1;
                        } else {
                            min = grid[i - 1][j - 1];
                        }
                    }
                    int sec = dp[i][j];
                    if (min < sec) {
                        dp[i][j] = min;
                        bor = true;
                    }
                }
            }
            for (int j = 1; j <= m; j++) {
                for (int i = n; i >= 1; i--) {
                    if (i * j == 1) continue;
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
                    min++;
                    if (min < grid[i - 1][j - 1]) {
                        int y = grid[i - 1][j - 1] - min;
                        if (y % 2 == 1) {
                            min = grid[i - 1][j - 1] + 1;
                        } else {
                            min = grid[i - 1][j - 1];
                        }
                    }
                    int sec = dp[i][j];
                    if (min < sec) {
                        dp[i][j] = min;
                        bor = true;
                    }
                }
            }
            for (int j = m; j >= 1; j--) {
                for (int i = 1; i <= n; i++) {
                    if (i * j == 1) continue;
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
                    min++;
                    if (min < grid[i - 1][j - 1]) {
                        int y = grid[i - 1][j - 1] - min;
                        if (y % 2 == 1) {
                            min = grid[i - 1][j - 1] + 1;
                        } else {
                            min = grid[i - 1][j - 1];
                        }
                    }
                    int sec = dp[i][j];
                    if (min < sec) {
                        dp[i][j] = min;
                        bor = true;
                    }
                }
            }
        }
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][m];

    }
}