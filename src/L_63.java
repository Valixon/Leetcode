import java.util.Scanner;

public class L_63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(uniquePathsWithObstacles(a));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                obstacleGrid[i][j] *= -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == -1) break;
            obstacleGrid[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            if (obstacleGrid[0][j] == -1) break;
            obstacleGrid[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == -1) continue;
                if (obstacleGrid[i - 1][j] != -1) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                }
                if (obstacleGrid[i][j - 1] != -1) {
                    obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                }
            }
        }
        return Math.max(obstacleGrid[n - 1][m - 1], 0);
    }
}
