import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Algo_0926 {
    private static ArrayList<Integer> res = new ArrayList<>();
    private static long sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sum = sc.nextLong();
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        Arrays.sort(a);
        general(a, n - 1);
        System.out.println(res);
    }

    private static void general(long[] a, int i) {
        if (sum == a[i]) {
            res.add(i);
            return;
        }
        if (sum < a[i] && i != 0) {
            general(a, i - 1);
        } else {
            if (sum > a[i]) {
                sum = sum - a[i];
                res.add(i);
                general(a, i);
                res.remove(res.lastIndexOf(i));
                sum = sum + a[i];
            }
        }

    }
}
