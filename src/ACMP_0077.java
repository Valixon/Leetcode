import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ACMP_0077 {
    static StringTokenizer st;
    static BufferedReader in;
    private static int d;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        String s = "";
        int y = 0;
        int a[][] = new int[n + 3][n + 3];
        for (int i = 1; i <= n; i++) {
            s = next();
            for (int j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(s.substring(j - 1, j));
                y = y + a[i][j];
            }
        }
        if (n == 1 && a[1][1] == 1) {
            pw.print("1");
            pw.close();
            return;
        }
        if (n * n == y) {
            pw.print(n * n);
            pw.close();
            return;
        }
        int p = 0, max = 0;
        d = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                d = 1;
                if (a[i][j] == 1) {
                    if (a[i + 1][j + 1] == 1) {
                        p = General1(a, i, j, 1);

                        if (max < p) {
                            max = p;
                        }
                    }
                }
            }
        }
        pw.print(max);
        pw.close();

    }

    private static int General1(int[][] a, int i, int j, int k) {
        // TODO Auto-generated method stub
        int l = 0;
        for (int k2 = i; k2 >= i - k + 1; k2--) {
            if (a[k2][j + 1] == 1) {
                l++;
            }
            //System.out.println("k2="+k2+" j+1"+(j+1));
        }
        for (int k2 = j; k2 >= j - k + 1; k2--) {
            //System.out.println("k2="+k2+" i+1"+(i+1));
            if (a[i + 1][k2] == 1) {
                l++;
            }
        }
        if (l == 2 * k) {
            d = d + l + 1;
            General1(a, i + 1, j + 1, k + 1);
        }
        return d;

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
