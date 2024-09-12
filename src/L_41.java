public class L_41 {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 3, 4, 5}));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length + 1;
        boolean[] a = new boolean[n + 2];
        for (int i : nums) {
            a[Math.max(0, Math.min(n + 1, i))] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (a[i]) return i;
        }
        return n + 1;
    }
}