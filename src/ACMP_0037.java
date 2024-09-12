import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ACMP_0037 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        long q = Double.valueOf(nextDouble() * 10000).longValue();
        long q1, q2;
        int k = 0;
        long x1, y1, x2, y2;
        for (int i = 1; i <= n; i++) {
            x1 = nextLong();
            y1 = nextLong();
            x2 = nextLong();
            y2 = nextLong();
            q1 = (x1 * x1) + (y1 * y1);
            q2 = (x2 * x2) + (y2 * y2);
            if (q * q * q1 >= q2 * 100000000) {
                k++;
            }
        }
        if (k == n) {
            pw.print("Yes");
        } else {
            pw.print("No");
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
