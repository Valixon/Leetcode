public class L_1267 {
    public static void main(String[] args) {
        System.out.println(countServers(new int[][]{{1, 0}, {0, 1}}));
        System.out.println(countServers(new int[][]{{1, 0}, {1, 1}}));
        System.out.println(countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}));
    }

    public static int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] a = new int[n];
        int[] b = new int[m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    res++;
                    a[i]++;
                    b[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && a[i] * b[j] == 1)
                    res--;
            }
        }
        return res;
    }
}
