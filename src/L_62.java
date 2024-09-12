import java.util.Scanner;

public class L_62 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(uniquePaths(sc.nextInt(), sc.nextInt()));
    }

    public static int uniquePaths(int m, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                a[j] = a[j] + a[j - 1];
                System.out.println((i + 1) + " " + (j + 1) + " " + a[j]);
            }
        }
        return a[n - 1];
    }
}
/*

5
3 4 1 1 0 0

9
1 1 1 1 1 1 1 1 7 1

6
4 1 1 1 1 2 1

35

1 0 4 0 4 1 4 3 1 1 1 2 1 4 0 3 0 3 0 3 0 5 3 0 0 1 2 1 2 4 3 0 1 0 5 2
 */