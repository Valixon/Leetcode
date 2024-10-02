import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L_1331 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{40, 10, 20, 30})));
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{100, 100, 100})));
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12})));
    }


    public static int[] arrayRankTransform(int[] nums) {
        int[] p = nums.clone();
        Arrays.sort(p);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int num : p) {
            if (map.containsKey(num)) continue;
            map.put(num, index++);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}
