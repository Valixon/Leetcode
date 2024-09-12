import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;


public class ACMP_0088 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int m = n;
        n = n * n;
        int q = 0, s1 = 0, s2 = 0, k = 0;
        int a[][] = new int[n + 1][n + 1];
        int b[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            q = q + i;
            for (int j = 1; j <= n; j++) {
                a[i][j] = nextInt();
            }
        }
        int t1, t2, w = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                w++;
                t1 = i * m + 1;
                t2 = j * m + 1;
                for (int j2 = t1; j2 <= t1 + m - 1; j2++) {
                    for (int l = t2; l <= t2 + m - 1; l++) {
                        b[w] = b[w] + a[j2][l];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                s1 = s1 + a[i][j];
                s2 = s2 + a[j][i];
            }
            if ((s1 == q) && (s2 == q) && (b[i] == q)) {
                k++;
            }
            s1 = s2 = 0;
        }
        if (k == n) {
            pw.print("Correct");
        } else {
            pw.print("Incorrect");
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
