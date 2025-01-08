import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ROBO_H {

    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        long n = nextLong();
        long a = (long) Math.sqrt(n) * 2;
        for (long i = 2; i < a; i++) {
            long urta = n / i;
            long ql = (i / 2 - ((i + 1) % 2));
            long qr = i / 2;
            long left = urta - (ql);
            long right = urta + (qr);
            if (left <= 0) return;
            if ((left + right) * i / 2 == n) {
                System.out.println(left + " " + right);
            }
        }

    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static String next() throws IOException {
        while (!st.hasMoreTokens() || st == null)
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
}
