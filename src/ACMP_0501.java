import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ACMP_0501 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int[][] a = new int[1000][1000];
        for (int i = 1; i <= n; i++) {
            int x1 = nextInt();
            int y1 = nextInt();
            int x2 = nextInt();
            int y2 = nextInt();
            for (int j =  Math.min(x1, x2) + 1; j <= Math.max(x1, x2); j++) {
                for (int j2 = Math.min(y1, y2) + 1; j2 <= Math.max(y1, y2); j2++) {
                    a[j][j2] = 1;
                }
            }
        }
        int x1 = nextInt();
        int y1 = nextInt();
        int x2 = nextInt();
        int y2 = nextInt();
        int sum = 0;
        for (int j = Math.min(x1, x2) + 1; j <= Math.max(x1, x2); j++) {
            for (int j2 = Math.min(y1, y2) + 1; j2 <= Math.max(y1, y2); j2++) {
                if (a[j][j2] == 1) {
                    sum++;
                }
            }
        }
        pw.println(sum);
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
