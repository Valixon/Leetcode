import java.util.Scanner;

public class L_905 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isMonotonic(new int[]{6}));
    }

    public static boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if (nums[0] > nums[n - 1]) {
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] < nums[i]) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < n; i++) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
