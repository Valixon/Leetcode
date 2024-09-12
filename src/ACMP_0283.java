import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ACMP_0283 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        String s = next()+"A";
        String a = " ";
        int k = 0;
        a = s;
        int n = s.length();
        if (n == 1) {
            pw.print("No");
            pw.close();
            return;
        }
        if (a.charAt(0) < 'A' || a.charAt(0) > 'Z') {
            pw.print("No");
            pw.close();
            return;
        }
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') {
                if (k < 1 || k > 3) {
                    pw.print("No");
                    pw.close();
                    return;
                }
                k = 0;
            } else {
                k++;
            }
        }
        pw.print("Yes");
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
