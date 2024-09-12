import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class R_0052 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        int n = nextInt();
        int[] a = new int[n + 1];
        int x = 1;

        List<Integer> index = new ArrayList<Integer>();
        index.add(n);
        for (int i = 1; i < n; i++) {
            index.add(i);
        }

        for (int i = 1; i <= n; i++) {
            x = x + i;
            x = x % index.size();
            a[index.get(x)] = i;
            index.remove(x);
        }
        for (int i = 1; i <= n; i++) {
            pw.print(a[i] + " ");
        }
        pw.close();
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