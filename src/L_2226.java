public class L_2226 {
    private static byte[] bytes;

    public static void main(String[] args) {
        int n = 10000000;
        int x = 2;
        for (int i = 0; i < 1000; i++) {
            System.out.print(n + ",");
        }
//        System.out.println(maximumCandies(new int[]{5, 8, 6}, 3));
//        System.out.println(maximumCandies(new int[]{2, 5}, 11));
    }


    public static int maximumCandies(int[] candies, long k) {
        long left = 1;
        long right = 1;
        long sum = 0;
        for (int num : candies) {
            sum += num;
        }
        right = (sum / k) + 1;
        while (left <= right) {
            long m = (right + left) / 2;
            if (bulami(candies, m, k)) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return (int) left - 1;
    }

    private static boolean bulami(int[] candies, long m, long k) {
        long p = 0;
        for (int num : candies) {
            p += (int) num / m;
        }
        return p >= k;
    }
}
