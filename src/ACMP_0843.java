import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;


public class ACMP_0843 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
//        long n = nextLong();
//        long m = nextLong();
//        long f = nextLong();
//        long l = nextLong();
//        long q = n - l;
//        if (q >= m + f) {
//            pw.print(0 + " " + m + " " + f);
//        } else {
//            long r = m + f - q;
//            pw.print(r + " " + (m - r) + " " + (f - r));
//
//        }
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);
        System.out.println(randomNum);
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
