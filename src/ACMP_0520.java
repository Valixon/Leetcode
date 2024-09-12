import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ACMP_0520 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int bog = 0;
        int bogqoldq = 0;
        int dona = 0;
        int top = n / 144;
        int topqoldiq = n % 144;
        if (topqoldiq > 133) {
            top = top + 1;
        } else {
            bog = topqoldiq / 12;
            bogqoldq = topqoldiq % 12;
            if (bogqoldq >= 10) {
                bog = bog + 1;
            } else {
                dona = bogqoldq;
            }

        }
        pw.print(top + " " + bog + " " + dona);
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
