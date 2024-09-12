import java.util.ArrayList;
import java.util.List;

public class L_1248 {

    private static List<List<Integer>> guruh = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
//        System.out.println(numberOfSubarrays(new int[]{2, 4, 6}, 1));
//        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
        System.out.println(numberOfSubarrays(new int[]{2044, 96397, 50143}, 1));
    }


    public static int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int left = 0, right = 0;
        int tempK = 0;
        while (right < nums.length) {
            if (nums[right] % 2 == 1) {
                tempK++;
            }
            if (tempK == k) {
                int ongTaraf = 0, chapTaraf = 0;
                for (int i = right + 1; i < nums.length; i++) {
                    if (nums[i] % 2 == 0) {
                        ongTaraf++;
                    } else {
                        right = i - 1;
                        break;
                    }
                }
                for (int i = left; i < nums.length; i++) {
                    if (nums[i] % 2 == 0) {
                        chapTaraf++;
                    } else {
                        left = i + 1;
                        break;
                    }
                }
                res += (ongTaraf + 1) * (chapTaraf + 1);
                tempK--;
            }
            right++;
        }
        return res;
    }
}