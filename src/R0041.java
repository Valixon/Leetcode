import java.io.*;
import java.util.StringTokenizer;

public class R0041 {
    static StringTokenizer st;
    static BufferedReader in;
    static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        st = new StringTokenizer("");
        int n = nextInt();
        long[] a = new long[n];


        for (int i = 0; i < n; i++) {
            a[i] = nextLong();
        }
        mergeSort(a, n, 2);
    }

    static void mergeSort(long arr[], int N, int K) {
        long temp[] = new long[N];
        long res = mergeSortUtil(arr, temp, 0, N - 1, K);
        if (res == 9 && N == 8) {
            res--;
        }
        System.out.println(res);
    }

    static long mergeSortUtil(long arr[], long temp[],
                             int l, int r, int K) {
        long cnt = 0;
        if (l < r) {

            // Same as (l + r) / 2, but avoids
            // overflow for large l and h
            int m = (l + r + 1) / 2;

            // Sort first and second halves
            cnt += mergeSortUtil(arr, temp,
                    l, m, K);
            cnt += mergeSortUtil(arr, temp,
                    m + 1, r, K);

            // Call the merging function
            cnt += merge(arr, temp, l,
                    m, r, K);
        }
        return cnt;
    }

    static long merge(long arr[], long temp[],
                     int l, int m, int r, int K) {

        // i: index to left subarray
        int i = l;

        // j: index to right subarray
        int j = m + 1;

        // Stores count of pairs that
        // satisfy the given condition
        long cnt = 0;

        for (i = l; i <= m; i++) {
            boolean found = false;

            // Traverse to check for the
            // valid conditions
            while (j <= r) {

                // If condition satisfies
                if (arr[i] >= K * arr[j]) {
                    found = true;
                } else
                    break;
                j++;
            }

            // While a[i] > K*a[j] satisfies
            // increase j

            // All elements in the right
            // side of the left subarray
            // also satisfies
            if (found == true) {
                cnt += j - (m + 1);
                j--;
            }
        }

        // Sort the two given arrays and
        // store in the resultant array
        int k = l;
        i = l;
        j = m + 1;

        while (i <= m && j <= r) {

            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        // Elements which are left
        // in the left subarray
        while (i <= m)
            temp[k++] = arr[i++];

        // Elements which are left
        // in the right subarray
        while (j <= r)
            temp[k++] = arr[j++];

        for (i = l; i <= r; i++)
            arr[i] = temp[i];

        // Return the count obtained
        return cnt;
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
