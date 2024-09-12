public class L_947 {


    public static void main(String[] args) {
    }

    private boolean[] xKurildi;
    private boolean[] yKurildi;
    private int n;

    public int removeStones(int[][] stones) {
        n = 0;
        for (int[] stone : stones) {
            n = Math.max(stone[0], Math.max(n, stone[1]));
        }
        n++;
        boolean[][] a = new boolean[n][n];
        xKurildi = new boolean[n];
        yKurildi = new boolean[n];
        for (int[] stone : stones) {
            a[stone[0]][stone[1]] = true;
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (xKurildi[i]) continue;
            for (int j = 0; j <= n; j++) {
                if (!yKurildi[j] && a[i][j]) {
                    sum++;
                    dfs(a, i, j);
                    break;
                }
            }
        }
        return stones.length - sum;
    }

    private void dfs(boolean[][] a, int i, int j) {
        a[i][j] = false;
        if (!xKurildi[i]) {
            xKurildi[i] = true;
            for (int k = 0; k <= n; k++) {
                if (a[i][k]) dfs(a, i, k);
            }
        }
        if (!yKurildi[j]) {
            yKurildi[j] = true;
            for (int k = 0; k <= n; k++) {
                if (a[k][j]) dfs(a, k, j);
            }
        }
    }
}