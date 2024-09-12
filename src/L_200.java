public class L_200 {

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        System.out.println(numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }

    public static int numIslands(char[][] grid) {
        int[][] a = new int[grid.length + 2][grid[0].length + 2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                a[i + 1][j + 1] = grid[i][j] - 48;
            }
        }
        int sum = 1;
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                if (a[i][j] == 1) {
                    sum++;
                    olay(i,j,sum, a);
                }
            }
        }
        return sum;
    }

    private static void olay(int i, int j, int sum, int[][] a) {
        
    }
}
