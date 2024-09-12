public class L_463 {

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
    }

    public static int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == 1) sum+=2;
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) sum+=2;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                if (grid[i][j - 1] == 0) sum++;
                if (grid[i - 1][j] == 0) sum++;
            }
        }
        return sum * 2;
    }
}
