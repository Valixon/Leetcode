import java.util.Scanner;

public class L_21s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countBits(n));
    }

    public static int countBits(int n) {
        long fac = 1;
        int nn = n;
        for (int i = 2; i <= 2 * n; i++) {
            int r = i;
            while (nn > 0 && r % 2 == 0) {
                r /= 2;
                nn--;
            }
            fac = (fac * r) % 1000000007;
        }
        return Integer.parseInt(String.valueOf(fac));
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