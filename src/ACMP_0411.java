import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;


public class ACMP_0411 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        double a = nextDouble();
        double b = nextDouble();
        double c = nextDouble();
        if (a == 0 && b == 0 && c == 0) {
            pw.print("-1");
            pw.close();
            return;
        }
        if (a == 0 && b == 0) {
            pw.print("0");
            pw.close();
            return;
        }
        if (a == 0) {
            pw.println("1");
            double x1 = (double) -c / b;
            pw.printf("%.6f", x1);
            pw.close();
            return;
        }
        double d = b * b - 4.0 * a * c;
        if (d > 0) {
            pw.println("2");
            double x1 = (double) (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (double) (-b - Math.sqrt(d)) / (2 * a);
            pw.printf("%.6f", x2);
            pw.println();
            pw.printf("%.6f", x1);
        } else {
            if (d == 0) {
                pw.println("1");
                double x1 = (double) -b / (2 * a);
                pw.printf("%.6f", x1);

            } else {
                pw.print("0");
            }
        }
        pw.close();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private static String next() throws IOException {
        while (!st.hasMoreTokens() || st == null)
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
}
