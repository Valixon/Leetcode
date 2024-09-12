import java.util.Arrays;
import java.util.Scanner;

public class L_542 {
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
        System.out.println(Arrays.toString(updateMatrix(a)));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] a = new int[n + 2][m + 2];
        for (int i = 0; i <= n + 1; i++) {
            a[i][0] = Integer.MAX_VALUE - 10000;
            a[i][m + 1] = Integer.MAX_VALUE - 10000;
        }
        for (int j = 0; j <= m + 1; j++) {
            a[0][j] = Integer.MAX_VALUE - 10000;
            a[n + 1][j] = Integer.MAX_VALUE - 10000;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = mat[i - 1][j - 1] * (Integer.MAX_VALUE - 10000);
            }
        }
        boolean salom = true;
        while (salom) {
            salom = false;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (a[i][j] == 0) continue;
                    int min = Math.min(Math.min(a[i - 1][j], a[i + 1][j]), Math.min(a[i][j - 1], a[i][j + 1]));
                    if (a[i][j] != min + 1) {
                        salom = true;
                    }
                    a[i][j] = min + 1;
                }
            }
            for (int i = n; i >= 1; i--) {
                for (int j = m; j >= 1; j--) {
                    if (a[i][j] == 0) continue;
                    int min = Math.min(Math.min(a[i - 1][j], a[i + 1][j]), Math.min(a[i][j - 1], a[i][j + 1]));
                    if (a[i][j] != min + 1) {
                        salom = true;
                    }
                    a[i][j] = min + 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                mat[i - 1][j - 1] = a[i][j];
            }
        }
        return mat;
    }
}
// 8 3    1 3 -1 -3 5 3 6 7