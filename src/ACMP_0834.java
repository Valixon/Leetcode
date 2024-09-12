import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;


public class ACMP_0834 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        double xk = nextDouble();
        double yk = nextDouble();
        double xc = nextDouble();
        double yc = nextDouble();
        double rc = nextDouble();
        double h = Math.sqrt((xk - xc) * (xk - xc) + (yk - yc) * (yk - yc));
        if (h > rc) {
            double k = Math.sqrt(h * h - rc * rc);
            double res = rc * k + (Math.PI * rc * rc * (1 - Math.asin(k / h) / Math.PI));
            pw.printf("%.3f", res);
        } else {
            pw.printf("%.3f", Math.PI * rc * rc);
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
