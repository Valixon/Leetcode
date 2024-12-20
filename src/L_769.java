import java.util.Arrays;

public class L_769 {
    public static void main(String[] args) {
//        System.out.println(maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
//        System.out.println(maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
//        System.out.println(maxChunksToSorted(new int[]{2, 0, 1}));
        System.out.println(maxChunksToSorted(new int[]{0, 2, 1, 4, 3}));
    }

    public static int maxChunksToSorted(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
        }
        Arrays.sort(a);
        int res = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            Arrays.sort(nums, start, i + 1);
            if (checkNums(nums, a, start, i)) {
                res++;
                start = i;
            }
        }
        return res;
    }

    private static boolean checkNums(int[] nums, int[] a, int start, int n) {
        for (int i = start; i <= n; i++) {
            if (nums[i] != a[i]) return false;
        }
        return true;
    }
}