public class L_2342 {

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{18, 43, 36, 13, 7}));
        System.out.println(maximumSum(new int[]{10, 12, 19, 14}));
    }


    public static int maximumSum(int[] nums) {
        int[][] a = new int[82][2];
        int max = -1;
        for (int num : nums) {
            int sum = getSum(num);
            int min1 = Math.min(a[sum][0], num);
            int max1 = Math.max(a[sum][0], num);
            a[sum][0] = max1;
            a[sum][1] = Math.max(min1, a[sum][1]);
        }
        for (int i = 1; i <= 81; i++) {
            if (a[i][0] > 0 && a[i][1] > 0) {
                max = Math.max(a[i][0] + a[i][1], max);
            }
        }
        return max;
    }

    private static int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
