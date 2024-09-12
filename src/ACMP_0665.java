import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ACMP_0665 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(System.out);
        String s = next();
        pw.println(result(s));
        pw.close();
    }

    private static String result(String s) {
        int soat = Integer.parseInt(s.substring(0, 2));
        int minut = Integer.parseInt(s.substring(3, 5));
        int vaqt = soat * 60 + minut;
        vaqt++;
        s = String.valueOf((vaqt / 60) % 24);
        if ((vaqt / 60) % 24 < 10) {
            s = "0" + s;
        }
        if (vaqt % 60 < 10) {
            s = s + ":0" + vaqt % 60;
        } else {
            s = s + ":" + vaqt % 60;
        }
        String s11 = s.substring(0, 1);
        String s12 = s.substring(1, 2);
        String s21 = s.substring(3, 4);
        String s22 = s.substring(4, 5);
        while (!(s11.equals(s22) && s12.equals(s21))) {
            vaqt++;
            vaqt = vaqt % (24 * 60);
            int sat = (vaqt / 60) % 24;
            int min = vaqt % 60;
            String s1 = String.valueOf(sat);
            if (sat < 10) {
                s1 = "0" + s1;
            }
            String s2 = String.valueOf(min);
            if (min < 10) {
                s2 = "0" + s2;
            }
            s11 = s1.substring(0, 1);
            s12 = s1.substring(1, 2);
            s21 = s2.substring(0, 1);
            s22 = s2.substring(1, 2);

        }
        return s11 + "" + s12 + ":" + s21 + "" + s22;
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
