import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;


public class R_0297 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        String s = next();
        String a[] = s.split("[^A-Za-z0-9]+|(?<=[A-Za-z])(?=[0-9])|(?<=[0-9])(?=[A-Za-z])");
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < a.length; i++) {
            try {
                sum = sum.add(new BigDecimal(a[i]));
                if (sum.equals(BigDecimal.ZERO)) continue;
                System.out.print(sum);
            } catch (NumberFormatException ex) {
                System.out.print(a[i]);
            }
        }
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static String next() throws IOException {
        while (!st.hasMoreTokens() || st == null)
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
}