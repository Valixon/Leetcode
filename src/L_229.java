import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_229 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3, 2, 2, 1}));
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{1}));
        System.out.println(majorityElement(new int[]{1, 2}));
    }

    public static List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int x = n / 3;
        x++;
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int old = nums[0];
        for (int i = 0; i < n; i++) {
            if (old == nums[i]) {
                count++;
                if (count == x) {
                    res.add(old);
                }
            } else {
                old = nums[i];
                count = 1;
                if (count == x) {
                    res.add(old);
                }
            }
        }
        return res;
    }

}
