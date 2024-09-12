import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class L_1438 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
        System.out.println(longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
    }


    public static int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int min;
        int max;
        int res = 1;
        TreeSet<Integer> map = new TreeSet<>();
        List<Integer> po = new ArrayList<>();
        while (right < n) {
            int x = nums[right];
            map.add(x);
            po.add(x);
            min = map.first();
            max = map.last();
            while (max - min > limit) {
                po.remove(Integer.valueOf(nums[left]));
                if (!po.contains(nums[left])) {
                    map.remove(nums[left]);
                }
                min = map.first();
                max = map.last();
                left++;
            }
            res = Math.max((right - left) + 1, res);
            right++;
        }
        return res;
    }
}