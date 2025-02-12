import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class L_1726 {

    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{2, 3, 4, 6}));
    }


    public static int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int o = nums.length;
        for (int i = 0; i < o; i++) {
            for (int j = i + 1; j < o; j++) {
                int x = nums[i] * nums[j];
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        int sum = 0;
        for (Integer count : map.values()) {
            if (count == 1) continue;
            sum += (count * (count - 1) * 4);
        }
        return sum;
    }
}
