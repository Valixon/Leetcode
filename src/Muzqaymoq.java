import java.util.Scanner;

public class Muzqaymoq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] c = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            c[i] = sc.nextInt();
        }
        int[][] a = new int[3001][n + 1];
        for (int i = 1; i <= n; i++) {
            if (a[c[i]][0] != 0) {
                a[c[i]][0] = c[i];
                continue;
            }
            a[c[i]][0] = c[i];
            a[c[i]][i] = 1;
        }
        for (int i = 2; i <= 3000; i++) {
            if (a[i][0] == 0) {
                int min = 0;
                for (int j = 1; j <= i / 2; j++) {
                    if (a[i - j][0] == i - j && a[j][0] == j) {
                        a[i][0] = i;
                        for (int k = 1; k <= n; k++) {
                            a[i][k] = a[i - j][k] + a[j][k];
                        }
                        break;
                    }
                    if (min == 0 && a[i - j][0] == i - j) {
                        min = i - j;
                    }
                }
                if (a[i][0] == 0) {
                    a[i][0] = min;
                    for (int k = 1; k <= n; k++) {
                        a[i][k] = a[min][k];
                    }
                }
            }
        }
        for (int i = 1; i <= 100; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        int q = sc.nextInt();
        for (int i = 1; i <= q; i++) {
            int x = sc.nextInt();
            System.out.println(a[x][0]);
            for (int k = 1; k <= n; k++) {
                System.out.print(a[x][k] + " ");
            }
            System.out.println();
        }

    }
}