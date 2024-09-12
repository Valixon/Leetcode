import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R_1159 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        long x = 1;
        long y = 2;
        while (x != y) {
            System.out.println("? " + x + " " + y);
            String z = next();
            if (z.equals("y")) {
                x = x * 2;
                y = y * 2;
            } else {
                break;
            }
        }
        while (x != y) {
            long p = (x + y) / 2;
            System.out.println("? " + x + " " + p);
            String z = next();
            if (z.equals("y")) {
                x = p;
            } else {
                y = p;
            }
            if (x+1 == y) break;
        }


        System.out.println("! " + y);
        System.out.flush();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static String next() throws IOException {
        while (!st.hasMoreTokens() || st == null) st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
}