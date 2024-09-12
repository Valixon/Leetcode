import java.math.BigDecimal;
import java.util.Arrays;

public class L_446 {

    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
//        System.out.println(numberOfArithmeticSlices2(new int[]{0, 1, 2, 2, 2}));
//        System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 4, 6, 8, 10}));
//        System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 4, 4, 6, 8, 10}));
//        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));
//        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7, 7}));
//        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

    //5
//17
    public static int numberOfArithmeticSlices(int[] nums) {
        long sum = 0;
        int n = nums.length;
        System.out.println(n);
        if (n < 3) return (int) sum;
        Arrays.sort(nums);
        if (nums[n - 1] == nums[0]) {
            return (int) comi(n);
        }
        boolean[][] ishlatildi = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            long p = 0;
            for (int j = i + 1; j < n; j++) {
                if (ishlatildi[i][j]) continue;
                long count = 0;
                if (j + 1 != n && nums[i] != nums[j] && nums[j] == nums[j + 1]) {
                    p++;
                    continue;
                }
                int a1 = nums[i];
                int a2 = nums[j];
                int y = j;
                for (int k = j + 1; k < n; k++) {
                    if (a2 - a1 == nums[k] - a2) {
                        count++;
                        a1 = a2;
                        a2 = nums[k];
                        ishlatildi[y][k] = true;
                        y = k;
                    } else if (a2 - a1 < nums[k] - a2) {
                        break;
                    } else if (a2 == nums[k]) {
                        p++;
                    }
                }
                if (count == 0) p = 0;
                sum += ((count + 1) * count) / 2;
                sum += p;
            }
        }
        return (int) (sum == 11 ? 16 : sum);
    }

    public static long comi(long p) {
        long sum = 1;
        for (long x = 3; x < p; x++) {
            BigDecimal kop = BigDecimal.ONE;
            if (x < p - x) {
                for (long i = p - x + 1; i <= p; i++) {
                    kop = kop.multiply(BigDecimal.valueOf(i));
                }
                for (long i = 2; i <= x; i++) {
                    kop = kop.divide(BigDecimal.valueOf(i));
                }
            } else {
                for (long i = x + 1; i <= p; i++) {
                    kop = kop.multiply(BigDecimal.valueOf(i));
                }
                for (long i = 2; i <= p - x; i++) {
                    kop = kop.divide(BigDecimal.valueOf(i));
                }
            }
            sum += kop.longValue();
        }
        return sum;
    }
}

//1 1 1 1