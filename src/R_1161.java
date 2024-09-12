import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;


public class R_1161 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
//        int t = nextInt();
//        Random rn = new Random();
//        while (t >= 0) {
//            t--;
//            int q = rn.nextInt(10) + 1;
//            int[] v = new int[q];
//            for (int i = 0; i < q; i++) {
//                v[i] = rn.nextInt(10) + 1;
//            }
//            if (salom(q, v) != salom2(q, v)) {
//                System.out.println(q);
//                for (int i = 0; i < q; i++) {
//                    System.out.print(v[i] + " ");
//                }
//                System.out.println();
//                System.out.println(salom(q,v));
//                System.out.println(salom2(q,v));
//            }
//        }

        int n = nextInt();
        int[] a = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            set.add(a[i]);
        }
        if (set.size() == 1){
            throw new IllegalArgumentException();
        }

        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            long tenglar = 1;
            long jummi = 0;
            long kichiklar = 0;
            long max = -1;
            boolean found = true;
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j] && found) {
                    tenglar++;
                    i++;
                    continue;
                } else {
                    found = false;
                    if (max == -1) max = a[j];
                    max = Math.max(max, a[j]);
                    if (max > a[i]) {
                        jummi++;
                        break;
                    }
                    if (max <= a[j]) {
                        if (a[i] >= a[j]) {
                            kichiklar++;
                        } else {
                            jummi++;
                        }
                    }
                }
            }
//            System.out.println((((jummi + jummi + tenglar - 1) * tenglar) / 2+" "+kichiklar + " " + jummi + " " + tenglar + " " + i));
            sum = sum + (((jummi + jummi + tenglar - 1) * tenglar) / 2);
            sum = sum + kichiklar;
        }
        System.out.println(sum);

    }

    private static long salom2(int n, int[] a) {
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            long tenglar = 1;
            long jummi = 0;
            long kichiklar = 0;
            long max = -1;
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    tenglar++;
                    i++;
                    continue;
                } else {
                    if (max == -1) max = a[j];
                    max = Math.max(max, a[j]);
                    if (max > a[i]) {
                        jummi++;
                        break;
                    }
                    if (max <= a[j]) {
                        if (a[i] >= a[j]) {
                            kichiklar++;
                        } else {
                            jummi++;
                        }
                    }
                }
            }
//            System.out.println((((jummi + jummi + tenglar - 1) * tenglar) / 2 + " " + jummi + " " + tenglar + " " + i));
            sum = sum + (((jummi + jummi + tenglar - 1) * tenglar) / 2);
            sum = sum + kichiklar;
        }
        return sum;
    }

    private static long salom(int n, int[] a) {
        long count = 0;
        int h;
        for (int i = 0; i < n - 1; i++) {
            h = 0;
            for (int j = i + 1; j < n; j++) {
                if (a[i] >= h && a[j] >= h) {
                    count++;
                    if (h < a[j]) h = a[j];
                } else if (h > a[i]) break;
            }

        }
        return count;
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