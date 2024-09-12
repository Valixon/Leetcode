import java.util.Scanner;

public class L_215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(findKthLargest(a, p));
    }

    public static int findKthLargest(int[] nums, int k) {
        int[] a = new int[20002];
        for (int num : nums) {
            a[num + 10000]++;
        }
        int x = 0;
        for (int i = 0; i < 20001; i++) {
            x += a[i];
            if (x >= (nums.length - k + 1)) {
                return i - 10000;
            }
        }
        return 0;
    }
}
