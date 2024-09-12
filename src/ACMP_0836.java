import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;


public class ACMP_0836 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int count = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            if (x % 2 == 0 && ((x / 64) % 8) % 2 == 1) {
                a[i] = x;
                count++;
            }
        }
        Arrays.sort(a);
        pw.println(count);
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                pw.print(a[i] + " ");
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
