import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R_0195 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");

        int n = nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        System.out.println(sumXOR(a, n));

    }

    static long sumXOR(int arr[], int n) {
        long sum = 0;
        for (int i = 0; i < 32; i++) {
            // Count of zeros and ones
            long zc = 0, oc = 0;

            // Individual sum at each bit position
            long idsum = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j] % 2 == 0)
                    zc++;

                else
                    oc++;
                arr[j] /= 2;
            }

            // calculating individual bit sum
            idsum = oc * zc * (1 << i);

            // final sum
            sum += idsum;
        }
        return sum;
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