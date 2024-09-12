import java.util.Arrays;
import java.util.Scanner;

public class L_2616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(minimizeMax(a, p));
    }

    public static int minimizeMax(int[] nums, int p) {
        if (p == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] x = new int[(n + 1) / 2];
        int[] y = new int[(n + 1) / 2];
        int[] z = new int[(n + 1) / 2];
        for (int i = 0; i < y.length; i++) {
            x[i] = Integer.MAX_VALUE;
            y[i] = Integer.MAX_VALUE;
            z[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n - 1; i = i + 2) {
            z[i / 2] = nums[i + 1] - nums[i];
        }
        int k = 0;
        int r = 0;
        for (int i = 0; i < n - 1; i++) {
            x[k] = nums[i + 1] - nums[i];
            if (i + 2 < n && r + 2 * p < n && nums[i + 2] - nums[i + 1] < x[k]) {
                x[k] = nums[i + 2] - nums[i + 1];
                i += 1;
                r++;
            }
            k++;
            i++;
        }
        for (int i = 0; i < n - 2; i = i + 2) {
            y[i / 2] = nums[i + 2] - nums[i + 1];
        }
        y[y.length - 1] = nums[n - 1] - nums[0];
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        System.out.println(Arrays.toString(z));
        Arrays.sort(x);
        Arrays.sort(y);
        Arrays.sort(z);
        return Math.min(z[p - 1], Math.min(x[p - 1], y[p - 1]));

    }

}
