import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ACMP_0667 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        if (n > 0 && k < 3) {
            pw.print(0);
            pw.close();
            return;
        }
        if (n == 0) {
            pw.print((n + k - 1) / k);
            pw.close();
            return;
        }
        int busCount = (n + k - 3) / (k - 2);
        if (busCount * 2 > m) {
            pw.print(0);
            pw.close();
            return;
        }
        pw.print((m + n + k - 1) / k);
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
