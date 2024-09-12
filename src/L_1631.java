import java.util.Scanner;

public class L_1631 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println(minimumEffortPath(a));
    }

    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        if (n * m == 1) return 0;
        int[][] a = new int[n + 2][m + 2];
        int[][] q = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = heights[i - 1][j - 1];
            }
        }
        for (int i = 0; i <= m + 1; i++) {
            a[0][i] = Integer.MAX_VALUE;
            a[n + 1][i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= n + 1; i++) {
            a[i][0] = Integer.MAX_VALUE;
            a[i][m + 1] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= m + 1; j++) {
                q[i][j] = Integer.MIN_VALUE;
            }
        }
        boolean yordimi = true;
        q[1][1] = 0;
        while (yordimi) {
            yordimi = false;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i * j == 1) continue;
                    int x = a[i][j];
                    int z = Integer.MAX_VALUE;
                    if (q[i + 1][j] != Integer.MIN_VALUE) {
                        z = Math.min(Math.abs(x - a[i + 1][j]), z);
                    }
                    if (q[i - 1][j] != Integer.MIN_VALUE) {
                        z = Math.min(Math.abs(x - a[i - 1][j]), z);
                    }
                    if (q[i][j + 1] != Integer.MIN_VALUE) {
                        z = Math.min(Math.abs(x - a[i][j + 1]), z);
                    }
                    if (q[i][j - 1] != Integer.MIN_VALUE) {
                        z = Math.min(Math.abs(x - a[i][j - 1]), z);
                    }
                    if (z != q[i][j]) {
                        q[i][j] = z;
                        yordimi = true;
                    }
                }
            }
        }

        return q[n][m];
    }
}
/*
5
1 2 1 1 1
1 2 1 2 1
1 2 1 2 2
1 2 1 2 1
1 1 1 2 1

5
0 0
2 2
3 10
5 2
7 0

3
JFK KUL
JFK NRT
NRT JFK

5
JFK SFO
JFK ATL
SFO ATL
ATL JFK
ATL SFO

JFK ATL SFO ATL JFK SFO

7
JFK ATL
ORD PHL
JFK ORD
PHX LAX
LAX JFK
PHL ATL
ATL PHX


6
29 51 87 87 72 12

9
1 1 1 1 1 1 1 1 7 1

6
4 1 1 1 1 2 1

35

1 0 4 0 4 1 4 3 1 1 1 2 1 4 0 3 0 3 0 3 0 5 3 0 0 1 2 1 2 4 3 0 1 0 5 2

7
3 3 3 3 3 1 3
 */

