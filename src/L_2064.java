public class L_2064 {
    public static void main(String[] args) {
        System.out.println(minimizedMaximum(15, new int[]{16, 24, 18, 26, 18, 28, 11, 8, 22, 26, 21, 23}));
        System.out.println(minimizedMaximum(6, new int[]{11, 6}));
        System.out.println(minimizedMaximum(7, new int[]{15, 10, 10}));
        System.out.println(minimizedMaximum(1, new int[]{10000}));
    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        countingSort(quantities, 100001);
        if (n == m) return quantities[m - 1];
        if (n == m + 1) return Math.max(quantities[m - 2], (quantities[m - 1] + 1) / 2);
        long sum = 0;
        for (int num : quantities)
            sum += num;
        int urtacha = (int) ((sum + n - 1) / n);
        int index = 0;
        while (quantities[index] <= urtacha) {
            sum -= quantities[index];
            n--;
            urtacha = (int) ((sum + n - 1) / n);
            index++;
        }
        int left = urtacha;
        int right = quantities[index];
        while (left < right) {
            int med = (left + right) / 2;
            if (bolami(quantities, index, med, n)) {
                right = med;
            } else {
                left = med + 1;
            }
        }
        return left;
    }

    private static boolean bolami(int[] nums, int index, int med, int n) {
        int sum = 0;
        for (int i = index; i < nums.length; i++) {
            sum += (nums[i] + med - 1) / med;
        }
        return sum <= n;
    }

    private static void countingSort(int[] nums, int maxValue) {
        int[] count = new int[maxValue];
        for (int num : nums)
            count[num]++;
        int index = 0;
        for (int i = 0; i < maxValue; i++)
            for (int j = 0; j < count[i]; j++)
                nums[index++] = i;
    }
}