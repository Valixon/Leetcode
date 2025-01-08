import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ROBO_B {

    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int n = nextInt();
        int m = nextInt();
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = nextInt();
            }
        }
        int q = nextInt();
        for (int i = 1; i <= q; i++) {
            int[] b = new int[m];
            for (int j = 0; j < m; j++) {
                b[j] = nextInt();
            }
            int res = 0;
            for (int j = 0; j < n; j++) {
                boolean bolami = true;
                for (int k = 0; k < m; k++) {
                    if (b[k] != -1 && b[k] != a[j][k]) {
                        bolami = false;
                        break;
                    }
                }
                if (bolami) res++;
            }
            System.out.println(res);
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
