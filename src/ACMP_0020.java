import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ACMP_0020 {
    static StringTokenizer st;
    static BufferedReader in;
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int[] a = new int[n + 1];
        TreeSet<Integer> sasa = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();
            sasa.add(a[i]);
        }
        if (sasa.size() == 1) {
            System.out.println(1);
            return;
        }

        int l = 0;

        int max = -2, k = 0, p = 0;
        int h = -1;
        for (int i = 2; i <= n - 1; i++) {
            if (a[i - 1] < a[i] && a[i] > a[i + 1]) {
                k++;
                if (h != 1) {
                    h = 1;
                } else {
                    max = Math.max(max, k);
                    k = 0;
                    h = -1;
                }
            } else if (a[i - 1] > a[i] && a[i] < a[i + 1]) {
                k++;
                if (h != 0) {
                    h = 0;
                } else {
                    max = Math.max(max, k);
                    k = 0;
                    h = -1;
                }
            } else {
                max = Math.max(max, k);
                k = 0;
                h = -1;
                p++;
            }
        }
        if (p + 2 == n) {
            System.out.println(0);
        } else {
            max = Math.max(max, k);
            pw.println(max + 2);
        }
        pw.close();
    }
    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static String next() throws IOException {
        while(!st.hasMoreTokens() || st==null)
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
}
