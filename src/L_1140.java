import java.util.Arrays;

public class L_1140 {
    public static void main(String[] args) {
        System.out.println(stoneGameII(new int[]{3111, 4303, 2722, 2183, 6351, 5227, 8964, 7167, 9286, 6626, 2347, 1465, 5201, 7240, 5463, 8523, 8163, 9391, 8616, 5063, 7837, 7050, 1246, 9579, 7744, 6932, 7704, 9841, 6163, 4829, 7324, 6006, 4689, 8781, 621}));
        System.out.println(stoneGameII(new int[]{2, 7, 9}));
//        System.out.println(stoneGameII(new int[]{2, 7, 9, 4, 4}));
        System.out.println(stoneGameII(new int[]{1, 2, 3, 4, 5, 100}));
    }


    public static int[][] op;
    public static int[] sum;

    public static int stoneGameII(int[] piles) {
        int n = piles.length;
        if (n < 3) {
            return Arrays.stream(piles).sum();
        }
        int dp[][] = new int[n + 1][n + 1];
        sum = new int[n + 1];
        op = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int sum1 = 0;
            for (int j = i; j <= n - 1; j++) {
                sum1 += piles[j];
                dp[i][j - i + 1] = sum1;
            }
            sum[i] = sum1;
        }
        int m = 1;
        return hisobla(dp, 0, m);
    }

    private static int hisobla(int[][] dp, int index, int m) {
        if (op[index][m] != 0) return op[index][m];
        int max1 = 0;
        int max2 = 0;
        for (int i = 1; i <= m * 2 && dp[index][i] != 0; i++) {
            max1 = hisobla(dp, index + i, Math.max(i, m));
            max2 = Math.max(max2, (sum[index] - max1));
        }
        op[index][m] = max2;
        return max2;
    }
}