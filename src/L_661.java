import java.util.Arrays;

public class L_661 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(imageSmoother(new int[][]{{5, 6, 2, 7, 4}, {5, 6, 2, 7, 4}})));
    }


    public static int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = 0, sum = 0;
                for (int k = Math.max(0, i - 1); k <= Math.min(n - 1, i + 1); k++) {
                    for (int l = Math.max(0, j - 1); l <= Math.min(m - 1, j + 1); l++) {
                        cnt++;
                        sum += img[k][l];
                    }
                }
                res[i][j] = sum / cnt;
            }
        }
        return res;
    }
}