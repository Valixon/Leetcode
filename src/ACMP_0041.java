import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ACMP_0041 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int[] a = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();

        }
        a[n + 1] = -101;
        Arrays.sort(a);
        int k = 0;
        for (int i = 1; i <= n + 1; i++) {
            if (a[i] == 0) {
                k++;
                if (k != 1) {
                    pw.print(a[i] + " ");
                }
            } else {
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
