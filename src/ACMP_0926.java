import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;


public class ACMP_0926 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int count = 0;
        int[] a = new int[5000];
        for (int i = 1; i <= n; i++) {
            String s = next();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'C') {
                    count++;
                    a[count] = (i - 1) * n + j + 1;
                }
            }
        }
        count = a[count / 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count != 0) {
                    count--;
                    pw.print(1);
                } else {
                    pw.print(2);
                }
            }
            pw.println();
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
