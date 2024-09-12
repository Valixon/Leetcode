import java.util.Arrays;

public class L_2441 {
    public static void main(String[] args) {
        System.out.println(findMaxK(new int[]{-1, 2, -3, 3}));
        System.out.println(findMaxK(new int[]{-1, 10, 6, 7, -7, 1}));
        System.out.println(findMaxK(new int[]{-10, 8, 6, 7, -2, -3}));
    }

    public static int findMaxK(int[] nums) {
        boolean[] a = new boolean[2002];
        for (int i : nums) {
            a[i + 1000] = true;
        }
        Arrays.sort(nums);
        for (int i : nums) {
            if (i < 0 && a[1000 + (i * -1)]) return i * -1;
        }
        return -1;
    }
}
