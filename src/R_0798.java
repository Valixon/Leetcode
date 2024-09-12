import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class R_0798 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int t = nextInt();
        while (t > 0) {
            t--;
            int n = nextInt();
            int a[] = new int[n];
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            Arrays.sort(a);
            for (int i = 0; i < n - 1; i++) {
                max = Math.min(max, ((a[i] ^ a[i + 1])));
            }
            System.out.println(max);
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