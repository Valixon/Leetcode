import java.io.PrintWriter;
import java.util.Scanner;

public class Sonlar_va_bitlar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long n = sc.nextLong();
        for (int i = 1; i <= Math.min(64, n); i++) {
            long sum = 0;
            String ikkilik = Long.toBinaryString(n - i);
            for (int j = 0; j < ikkilik.length(); j++) {
                if (ikkilik.charAt(j) == '1') {
                    sum++;
                }
            }
            if (n == (n - i) + sum) {
                out.println(n - i);
                out.flush();
                return;
            }
        }
        out.println(-1);
        out.flush();
    }
}
