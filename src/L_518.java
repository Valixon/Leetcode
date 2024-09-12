import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L_518 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(change(p, a));
    }

    public static int change(int target, int[] nums) {
        int index = Arrays.binarySearch(nums, target);
        System.out.println(index);

        return index;
//        if (amount == 0) return 1;
//        long[] a = new long[5001];
//        long[] b = new long[5001];
//        a[0] = 1;
//        b[0] = 1;
//        for (int coin : coins) {
//            b[coin] = 1;
//            a[coin] = 1;
//        }
//        for (int i = 2; i <= amount; i++) {
//            for (int j = 1; j <= i / 2; j++) {
//                long r = (a[i - j] * a[j]) - ((a[i - j] - b[i - j]) / a[j]);
//                a[i] = Math.max(a[i], r);
//            }
//            a[i] += b[i];
//            System.out.println(i + " " + a[i]);
//        }
//        return (int) a[amount];
    }
}
