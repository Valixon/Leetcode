public class L_525 {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1}));
        System.out.println(findMaxLength(new int[]{0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0}));
        System.out.println(findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0}));

    }


    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] soni = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            soni[i] += (soni[i - 1] + nums[i - 1]);
        }
        int qadam = Math.min(soni[n], n - soni[n]);
        for (int i = qadam; i >= 1; i--) {
            for (int j = 1; j <= n - (2 * i) + 1; j++) {
                if (soni[j + (2 * i) - 1] - soni[j - 1] == i) {
                    return 2 * i;
                }
            }
        }
        return 0;
    }
}