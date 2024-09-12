import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ACMP_0315 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        String s = nextLine();
        char a[] = s.toCharArray();
        char max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (isDigit(a[i]) || isText(a[i])) {
                if (a[i] > max) {
                    max = a[i];
                }
            } else {
                pw.print("-1");
                pw.close();
                return;
            }
        }
        if ((isDigit(max))) {
            pw.print(max == '0' ? "2" : max - '0' + 1);
        } else {
            pw.print(max - 'A' + 11);
        }
        pw.close();

    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isText(char c) {
        return c >= 'A' && c <= 'Z';
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

    private static String nextLine() throws IOException {
        return in.readLine();
    }
}