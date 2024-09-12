import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class R_0094 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        long[] satr = new long[n];
        int a;
        long max = 0;
        long sum = 0;
        long ustun;
        for (int i = 0; i < n; i++) {
            ustun = 0;
            for (int j = 0; j < n; j++) {
                a = nextInt();
                ustun += a;
                satr[j] += a;
            }
            sum += ustun;
            max = Math.max(max, ustun);
        }
        Arrays.sort(satr);
        max = Math.max(max, satr[n - 1]);
        pw.print((max * n) - sum);
        pw.close();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static String next() throws IOException {
        while (!st.hasMoreTokens() || st == null)
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
}