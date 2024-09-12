import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class ACMP_0038 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int[] a = new int[n];
        TreeSet<Integer> all = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            all.add(a[i]);
        }
        if (all.size() == 1 && n % 2 == 0) {
            System.out.println(0);
            return;
        }
        int ong = n - 1, chap = 0;
        int[] sum = new int[3];
        int index = 0;
        while (ong != chap) {
            if (a[chap] - Math.max(a[chap + 1], a[ong]) >= a[ong] - Math.max(a[chap], a[ong - 1])) {
                sum[index] += a[chap];
                chap++;
            } else {
                sum[index] += a[ong];
                ong--;
            }
            index = (index + 1) % 2;
        }
        if (sum[0] == sum[1]) {
            System.out.println(0);
        } else if (sum[0] > sum[1]) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }

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
