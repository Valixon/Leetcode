import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;


public class C_Masala {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int q = nextInt();
        System.out.printf("%.4f",((double)(n*q)/2));
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt() % 103;
        }
        for (int i = 1; i <= q; i++) {
            int left = nextInt();
            int right = nextInt();
            int res = 0;
            int[] map = new int[103];
            for (int j = right - 1; j >= left - 1; j--) {
                map[a[j]]++;
            }
            for (int j = 0; j < 103; j++) {
                if (map[j] == 2) res++;
            }
            System.out.println(res);
        }
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
