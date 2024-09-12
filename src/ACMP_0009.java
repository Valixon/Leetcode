import java.io.PrintWriter;
import java.util.Scanner;

public class ACMP_0009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        long max = 0, min = 0, p = 1;
        int k = 0, l = 0, s = 0;
        int n = sc.nextInt();
        long[] a = new long[n + 1];
        max = -100000;
        min = 100000;
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            if (a[i] > 0) {
                l += a[i];
            }
            if (a[i] >= max) {
                max = a[i];
                s = i;
            }
            if (min >= a[i]) {
                min = a[i];
                k = i;
            }
        }
        if (k > s) {
            for (int i = s + 1; i < k; i++) {
                p = p * a[i];
            }
        } else
            for (int j = k + 1; j < s; j++) {
                p = p * a[j];
            }
        pw.print(l + " " + p);
        pw.close();
    }
}
