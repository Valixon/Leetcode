import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;


public class ACMP_0912 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int a[] = new int[101];
        int summ = 0;
        for (int i = 0; i < n; i++) {
            a[nextInt()]++;
        }
        int max = -10001;
        int index = 0;
        for (int i = 1; i <= 100; i++) {
            if (a[i] > max) {
                max = a[i];
                index = i;
            }
        }
        Arrays.sort(a);
        if (a[100] == a[99]) {
            pw.println(0);
        } else {
            pw.println(index);
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
