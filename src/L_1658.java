import java.util.Arrays;
import java.util.Scanner;

public class L_1658 {
    private static boolean[] bordimi;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(minOperations(a, k));
    }

    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        a[0] = 0;
        b[0] = 0;
        int aindex = n - 1;
        int bindex = n - 1;
        for (int i = 1; i <= n; i++) {
            if (a[i - 1] + nums[i - 1] > x) break;
            a[i] = a[i - 1] + nums[i - 1];
            aindex = i;
        }
        for (int i = 1; i <= n; i++) {
            if (b[i - 1] + nums[n - i] > x) break;
            b[i] = b[i - 1] + nums[n - i];
            bindex = i;
        }
        if (a[n] != 0 && a[n] < x) {
            return -1;
        }
        if (a[n] == x) {
            return n;
        }
        int min = 100001;
        for (int i = 0; i <= Math.min(aindex, min); i++) {
            int index = Arrays.binarySearch(b, 0, bindex + 1, x - a[i]);
            if (index > -1) {
                min = Math.min(i + index, min);
            }
        }
        for (int j = 0; j <= Math.min(bindex, min); j++) {
            int index = Arrays.binarySearch(a, 0, aindex + 1, x - b[j]);
            if (index > -1) {
                min = Math.min(j + index, min);
            }
        }
        if (min == 100001) {
            return -1;
        }
        return min;
    }
}

/*
6
1
    1
3
    0 2 4
2
    1 3
1
    2
2
    1 5
1
    4


5
4
1 2 3 4
1
0
1
0
1
0
1
0

5
1
1
3
0 2 4
3
1 3  4
1
2
2
1 2




 */

