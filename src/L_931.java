public class L_931 {
    public static void main(String[] args) {
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int yasama[][] = new int[n + 2][n + 2];
        for (int i = 0; i <= n + 1; i++) {
            yasama[i][0] = 10000;
            yasama[i][n + 1] = 10000;
            yasama[0][i] = 10000;
            yasama[n + 1][i] = 10000;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                yasama[i][j] = matrix[i - 1][j - 1];
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                yasama[i][j] = Math.min(yasama[i - 1][j + 1], Math.min(yasama[i - 1][j], yasama[i - 1][j - 1]));
            }
        }
        int min = 10000;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, yasama[n][i]);
        }
        return min;
    }
}