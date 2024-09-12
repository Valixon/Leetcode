import java.util.Arrays;
import java.util.Scanner;

public class R0917 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long summ1 = 0;
        long summ2 = 0;
        long[] a = new long[n];
        for (int i = 1; i <= n; i++) {
            long x = sc.nextLong();
            a[i - 1] = x;
            summ1 = summ1 + x;
        }
        for (int i = 1; i <= n; i++) {
            long x = sc.nextLong();
            summ2 = summ2 + x;
        }
        Arrays.sort(a);
        if (summ1 > summ2) {
            long dif = summ1 - summ2;
            for (int i = 0; i < n; i++) {
                if (dif <= a[i]) {
                    System.out.println(summ2 + a[i]);
                    return;
                }
            }
        } else {
            System.out.println(summ2 + a[0]);
        }
    }
}
