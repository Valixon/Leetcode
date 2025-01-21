public class L_2017 {
    public static void main(String[] args) {
        System.out.println(gridGame(new int[][]{{2, 5, 4}, {1, 5, 1}}));
        System.out.println(gridGame(new int[][]{{3, 3, 1}, {8, 5, 2}}));
        System.out.println(gridGame(new int[][]{{1, 3, 1, 15}, {1, 3, 3, 1}}));
    }

    public static long gridGame(int[][] grid) {
        int n = grid[0].length;
        long a = 0;
        long b = 0;
        for (int i = 0; i < n - 1; i++) {
            b += grid[1][i];
        }
        long res = b;
        long c;
        for (int i = n - 1; i > 0; i--) {
            a += grid[0][i];
            b -= grid[1][i - 1];
            c = b;
            if (a > b) {
                c = a;
            }
            if (res > c) {
                res = c;
            }
        }
        return res;
    }
}
