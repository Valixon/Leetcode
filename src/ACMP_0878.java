import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;


public class ACMP_0878 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        String s = next();
        char a[] = s.toCharArray();
        int b[] = new int['Z' + 1];
        int c[] = new int[26];
        for (int i = 0; i < 26; i++) {
            if (b[a[i]] == 0) {
                b[a[i]] = ((int) a[i] - (int) 'A') + 1;
                c[i] = b[a[i]];
            } else {
                while (a[i] >= 'A') {
                    a[i]--;
                    if (b[a[i]] == 0) {
                        b[a[i]] = ((int) a[i] - (int) 'A') + 1;
                        c[i] = b[a[i]];
                        break;
                    }
                }
            }
        }
        boolean xx = true;
        for (int i = 0; i <= 25; i++) {
            if (c[i] == 0) {
                xx = false;
                break;
            }
        }
        if (xx) {
            pw.println("YES");
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i <= 25; i++) {
                map.put(c[i], i+1);
            }
            for (int i = 1; i <= 26; i++) {
                pw.print(map.get(i) + " ");
            }
        } else {
            pw.print("NO");
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
        while (!st.hasMoreTokens() || st == null) st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
}
