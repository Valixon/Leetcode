import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class L_239 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(maxSlidingWindow(a, p)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        return nums;
    }
}
// 8 3    1 3 -1 -3 5 3 6 7