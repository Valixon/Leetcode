import java.util.Arrays;
import java.util.Scanner;

public class L_1326 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(minTaps(n, a));
    }

    public static int minTaps(int n, int[] ranges) {
        int[] otiz = new int[n];
        int boshi = 0;
        int oxiri = 0;
        boolean qoshsin = false;
        for (int i = 0; i <= n; i++) {
            boshi = Math.max(i - ranges[i], 0);
            oxiri = Math.min(i + ranges[i], n);
            qoshsin = false;
            for (int j = oxiri - 1; j >= boshi; j--) {
                if (otiz[j] == 0) {
                    qoshsin = true;
                    break;
                }
            }
            if (qoshsin) {
                for (int j = boshi; j < oxiri; j++) {
                    otiz[j]++;
                }
            } else {
                ranges[i] = 0;
            }
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            boshi = Math.max(i - ranges[i], 0);
            oxiri = Math.min(i + ranges[i], n);
            qoshsin = true;
            for (int j = oxiri - 1; j >= boshi; j--) {
                if (otiz[j] == 1) {
                    sum++;
                    System.out.println(i);
                    qoshsin = false;
                    break;
                }
            }
            if (qoshsin) {
                for (int j = boshi; j < oxiri; j++) {
                    otiz[j]--;
                }
            }
        }
        System.out.println(Arrays.toString(otiz));
        for (int i = 0; i < n; i++) {
            if (otiz[i] == 0) return -1;
        }
        return sum;
    }
}
/*

5
3 4 1 1 0 0

9
1 1 1 1 1 1 1 1 7 1

6
4 1 1 1 1 2 1

35

1 0 4 0 4 1 4 3 1 1 1 2 1 4 0 3 0 3 0 3 0 5 3 0 0 1 2 1 2 4 3 0 1 0 5 2
 */