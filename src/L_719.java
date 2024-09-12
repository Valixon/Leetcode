import java.util.Arrays;

public class L_719 {
    public static void main(String[] args) {
//        System.out.println(smallestDistancePair(new int[]{1, 3, 1}, 1));
//        System.out.println(smallestDistancePair(new int[]{1, 1, 1}, 2));
//        System.out.println(smallestDistancePair(new int[]{1, 6, 1}, 3));
        System.out.print("[");
        for (int i = 1; i < 10000; i++) {
            System.out.print(i + ", ");
        }
        System.out.print("1000000]");

    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 1;
        int n = nums.length;
        while (k > n - i) {
            k = k - n + i;
            i++;
        }
        int[] a = new int[1000000];
        int y = 0;
        int index = 0;
        for (int q = 100; q >= 1; q--) {
            if (i > q) {
                index += n - (i - q);
                for (int j = 0; j < n - (i - q); j++) {
                    a[y++] = (nums[j + i - q] - nums[j]);
                }
            }
        }
        for (int q = 0; q <= 80; q++) {
            for (int j = 0; j < n - (i + q); j++) {
                a[y++] = (nums[j + i + q] - nums[j]);
            }
        }
        Arrays.sort(a, 0, y);
        return a[(index + (k - 1))];
    }
}