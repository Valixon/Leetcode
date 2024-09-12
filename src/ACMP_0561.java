import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Locale;
import java.util.StringTokenizer;


public class ACMP_0561 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            int k = nextInt();
            int[] a = new int[k+1];
            for (int j = 0; j < a.length; j++) {
                a[j] = nextInt();
            }
            BigInteger daraja = new BigInteger(String.valueOf(a[k]));
            for (int j = k - 1; j >= 0; j--) {
                daraja = binPow(new BigInteger(String.valueOf(a[j])), daraja);
                daraja = daraja.sqrt();
            }
            System.out.println(daraja);
        }
        pw.close();
    }

    static BigInteger binPow(BigInteger a, BigInteger n) {
        if (BigInteger.ZERO.compareTo(n) == 0) return BigInteger.ONE;
        if (BigInteger.ZERO.compareTo(n.mod(BigInteger.TWO)) == 0) {
            BigInteger x = binPow(a, n.divide(BigInteger.TWO));
            return x.multiply(x);
        }
        return a.multiply(binPow(a, n.subtract(BigInteger.ONE)));
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
