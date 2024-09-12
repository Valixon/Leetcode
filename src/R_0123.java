import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class R_0123 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int n = nextInt();
        int k = nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        int a = 0;
        int x, one;
        for (int i = 0; i < n; i++) {
            a = nextInt();
            sum += map.getOrDefault(a, 0);
            x = a ^ k;
            one = map.getOrDefault(x, 0);
            one++;
            map.put(x, one);

        }
        System.out.println(sum);
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static String next() throws IOException {
        while (!st.hasMoreTokens() || st == null)
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
}