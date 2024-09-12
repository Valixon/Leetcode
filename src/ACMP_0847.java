import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ACMP_0847 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        String s1 = next();
        String s2 = next();
        if (s1.length() != s2.length()) {
            pw.print("NO");
            pw.close();
            return;
        }
        char a1[] = s1.toCharArray();
        char a2[] = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                pw.print("NO");
                pw.close();
                return;
            }
            if (s1.charAt(i) == s2.charAt(i)) {
                pw.print("NO");
                pw.close();
                return;
            }
        }
        pw.print("YES");
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
