import java.util.Arrays;

public class L_1289 {
    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}}));
    }

    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        for (int i = n - 2; i >= 0; i--) {
            int[] a = grid[i + 1].clone();
            Arrays.sort(a);
            for (int j = 0; j < n; j++) {
                if (grid[i + 1][j] == a[0]) {
                    grid[i][j] += a[1];
                } else {
                    grid[i][j] += a[0];
                }
            }
        }
        int res = grid[0][0];
        for (int j = 0; j < n; j++) {
            res = Math.min(grid[0][j], res);
        }
        return res;
    }
}
