import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ROBO_E {

    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int n = nextInt();
        char[] s2 = next().toCharArray();
        char[] s1 = next().toCharArray();
        Arrays.sort(s2);
        for (int i = 0; i < n; i++) {
            if (s1[i] == s2[i]) {
                for (int j = i + 1; j < n; j++) {
                    if (s1[i] != s2[j]) {
                        char temp = s2[j];
                        s2[j] = s2[i];
                        s2[i] = temp;
                        break;
                    }
                }
                if (s1[i] == s2[i]) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (s1[i] != s2[j] && s2[i] != s1[j]) {
                            char temp = s2[j];
                            s2[j] = s2[i];
                            s2[i] = temp;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((s2[i] == 'b' && s2[j] == 'a' && s1[i] == 'c' && s1[j] == 'c')
                        || (s2[i] == 'c' && s2[j] == 'b' && s1[i] == 'a' && s1[j] == 'a')) {
                    char temp = s2[i];
                    s2[i] = s2[j];
                    s2[j] = temp;
                }
            }
        }
        for (char i : s2) {
            System.out.print(i);
        }
    }


//    bacabbcaccc
//    bccaaacbccb

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
