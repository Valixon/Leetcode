import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ACMP_0034 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int k = nextInt();
        String s = next();
        String a[] = new String[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            a[i] = s.substring(i, i + k);
        }
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].equals(a[i + 1])) {
                pw.println("YES");
                pw.close();
                return;
            }
        }
        pw.println("NO");
        pw.close();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static String next() throws IOException {
        while (!st.hasMoreTokens() || st == null)
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
}
