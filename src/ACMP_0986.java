import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;


public class ACMP_0986 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        double x = nextDouble();
        double y = nextDouble();
        double l = nextDouble();
        for (int i = 0; i < n; i++) {
            double x1 = nextDouble();
            double y1 = nextDouble();
            if (getLength(x, y, x1, y1) <= l) {
                pw.println(i + 1);
                pw.close();
                return;
            }
        }
        pw.println("Yes");
        pw.close();
    }

    private static double getLength(double x, double y, double x1, double y1) {
        return Math.abs(Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1)));
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
