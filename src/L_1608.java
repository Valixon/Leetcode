import java.util.Arrays;
import java.util.Scanner;

public class L_1608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(specialArray(new int[]{3, 5}));
        System.out.println(specialArray(new int[]{0, 0}));
        System.out.println(specialArray(new int[]{0, 4, 3, 0, 4}));
        System.out.println(specialArray(new int[]{3, 6, 7, 7, 0}));
    }

    public static int specialArray(int[] nums) {
        int res = -1;
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    if (nums.length - j == i) {
                        res = i;
                    }
                    break;
                }
            }
        }
        return res;
    }
}

