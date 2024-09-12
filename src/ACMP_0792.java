import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;


public class ACMP_0792 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n1 = nextInt();
        int p1 = nextInt();
        int n2 = nextInt();
        int p2 = nextInt();
        String s1 = Integer.toString(n1, p1);
        String s2 = Integer.toString(n2, p2);
        int sumNumber1 = sumNumber(s1, p1);
        int sumNumber2 = sumNumber(s2, p2);
        if (sumNumber1 == sumNumber2) {
            pw.print(sumNumber1);
        } else {
            pw.print(0);
        }
        pw.close();
    }

    private static int sumNumber(String s, int p) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += Integer.parseInt(s.substring(i, i + 1), p);
        }
        return result;
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
