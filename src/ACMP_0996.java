import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;


public class ACMP_0996 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int[] a = new int[n + 1];
        a[1] = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            if (set.contains(i)) {
                a[i] = a[i - 1] + 3;
            } else {
                a[i] = a[i - 1] + 2;
            }
            set.add(a[i]);
        }
        pw.print(a[n]);
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
