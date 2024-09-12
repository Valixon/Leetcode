public class L_861 {
    public static void main(String[] args) {
        System.out.println(getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));
        System.out.println(getMaximumGold(new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}}));
    }


    public static int getMaximumGold(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] a = new int[n + 2][m + 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i + 1][j + 1] = grid[i][j];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] != 0) {
                    int y = a[i][j];
                    a[i][j] = 0;
                    max = Math.max(hisobla(i, j, a) + y, max);
                    a[i][j] = y;
                }
            }
        }
        return max;
    }

    private static int hisobla(int indexI, int indexJ, int[][] a) {
        int max = 0;
        if (a[indexI][indexJ - 1] != 0) {
            int y = a[indexI][indexJ - 1];
            a[indexI][indexJ - 1] = 0;
            max = y + hisobla(indexI, indexJ - 1, a);
            a[indexI][indexJ - 1] = y;
        }
        if (a[indexI - 1][indexJ] != 0) {
            int y = a[indexI - 1][indexJ];
            a[indexI - 1][indexJ] = 0;
            max = Math.max(max, y + hisobla(indexI - 1, indexJ, a));
            a[indexI - 1][indexJ] = y;
        }
        if (a[indexI + 1][indexJ] != 0) {
            int y = a[indexI + 1][indexJ];
            a[indexI + 1][indexJ] = 0;
            max = Math.max(max, y + hisobla(indexI + 1, indexJ, a));
            a[indexI + 1][indexJ] = y;
        }
        if (a[indexI][indexJ + 1] != 0) {
            int y = a[indexI][indexJ + 1];
            a[indexI][indexJ + 1] = 0;
            max = Math.max(max, y + hisobla(indexI, indexJ + 1, a));
            a[indexI][indexJ + 1] = y;
        }
        return max;
    }
}