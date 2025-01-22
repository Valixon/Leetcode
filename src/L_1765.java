import java.util.Arrays;

public class L_1765 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(highestPeak(new int[][]{{0, 1}, {0, 0}})));
        System.out.println(Arrays.deepToString(highestPeak(new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}})));
        System.out.println(Arrays.deepToString(highestPeak(new int[][]{{0, 0, 0, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 0, 0}})));
    }

    public static int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] boshliq = new int[n + 2][m + 2];
        int max = n + m;
        for (int i = 0; i <= n + 1; i++) {
            boshliq[i][0] = max;
            boshliq[i][m + 1] = max;
        }
        for (int i = 0; i <= m + 1; i++) {
            boshliq[0][i] = max;
            boshliq[n + 1][i] = max;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boshliq[i + 1][j + 1] = (isWater[i][j] - 1) * max * -1;
            }
        }
        boolean bormiOgriq = true;
        while (bormiOgriq) {
            bormiOgriq = false;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (boshliq[i][j] == 0) continue;
                    int min = boshliq[i - 1][j];
                    if (min > boshliq[i + 1][j]) {
                        min = boshliq[i + 1][j];
                    }
                    if (min > boshliq[i][j + 1]) {
                        min = boshliq[i][j + 1];
                    }
                    if (min > boshliq[i][j - 1]) {
                        min = boshliq[i][j - 1];
                    }
                    if (min + 1 != boshliq[i][j]) {
                        boshliq[i][j] = min + 1;
                        bormiOgriq = true;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.arraycopy(boshliq[i], 1, isWater[i - 1], 0, m);
        }
        return isWater;
    }
}
