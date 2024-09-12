import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;


public class ACMP_0967 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int k1 = nextInt();
        int k2 = nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            b[i] = getNumber(a[i], k1) * getNumber(a[i], k2);
        }
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            pw.print(b[i] + " ");
        }
        pw.close();
    }

    private static int getNumber(int i, int k) {
        String s = Integer.toString(i, k);
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            res += Integer.parseInt(s.substring(j, j + 1));
        }
        return res;
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
        while (!st.hasMoreTokens() || st == null) st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
}
