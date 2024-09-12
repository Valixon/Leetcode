import java.util.Arrays;
import java.util.Scanner;

public class L_338 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Arrays.toString(countBits(n)));
    }

    public static int[] countBits(int n) {
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = a[i / 2] + i % 2;
        }
        return a;
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