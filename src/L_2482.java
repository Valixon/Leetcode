import java.util.Arrays;

public class L_2482 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(onesMinusZeros(new int[][]{{0, 1, 1}, {1, 0, 1}, {0, 0, 1}})));
        System.out.println(Arrays.deepToString(onesMinusZeros(new int[][]{{1, 1, 1}, {1, 1, 1}})));

    }


    public static int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int an[] = new int[n];
        int am[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int t = grid[i][j];
                an[i] += t;
                am[j] += t;
            }
        }
        int ayirma = n + m;
        for (int i = 0; i < n; i++) {
            int t = an[i] * 2 - ayirma;
            for (int j = 0; j < m; j++) {
                grid[i][j] = t + (2 * am[j]);
            }
        }
        return grid;
    }
}