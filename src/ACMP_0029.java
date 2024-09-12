import java.io.PrintWriter;
import java.util.Scanner;


public class ACMP_0029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] a = new int[n + 3];
        int[] d = new int[n + 3];
        d[1] = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        d[2] = Math.abs(a[2] - a[1]);
        for (int i = 3; i <= n; i++) {
            d[i] = Math.min(d[i - 2] + 3 * Math.abs(a[i] - a[i - 2]), d[i - 1] + Math.abs(a[i] - a[i - 1]));
        }
        pw.print(d[n]);
        pw.close();
    }
}
