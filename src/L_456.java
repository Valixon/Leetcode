import java.math.BigDecimal;
import java.util.Scanner;

public class L_456 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal rate = new BigDecimal("0");
        System.out.println(rate.compareTo(BigDecimal.ZERO));
        rate = new BigDecimal("0.1");
        System.out.println(rate.compareTo(BigDecimal.ZERO));
        rate = new BigDecimal("-0.1");
        System.out.println(rate.compareTo(BigDecimal.ZERO));
        rate = new BigDecimal("1");
        System.out.println(rate.compareTo(BigDecimal.ZERO));

        System.out.println(find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(find132pattern(new int[]{-1, 3, 2, 0}));
        System.out.println(find132pattern(new int[]{0, -100000, 200000, -300000, 400000, -500000, 600000, -700000, 800000, -900000, 1000000, -1100000, 1200000, -1300000, 1400000, -1500000, 1600000, -1700000, 1800000}));
    }

    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= nums[j]) continue;
                for (int k = j + 1; k < nums.length; k++) {
                    count++;
                    if (count >= 100000) {
                        return false;
                    }
                    if (nums[i] < nums[k] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
