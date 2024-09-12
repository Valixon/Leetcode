import java.util.HashMap;
import java.util.Map;

public class L_1814 {
    public static void main(String[] args) {
        System.out.println(countNicePairs(new int[]{352171103, 442454244, 42644624, 152727101, 413370302, 293999243}));
    }

    public static int countNicePairs(int[] nums) {
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int x = Math.abs(num - rev(num));
            int v = 1;
            if (map.containsKey(x)) {
                v = map.get(x);
                v++;
            }
            map.put(x, v);
        }
        for (Integer k : map.keySet()) {
            long v = map.get(k);
            sum += ((v) * (v - 1) / 2);
        }

        return (int) (sum % 1000000007);
    }

    public static boolean isPalindrome(int num) {
        StringBuilder s = new StringBuilder("" + num);
        s.reverse();
        return s.toString().equals("" + num);
    }

    public static int rev(int num) {
        StringBuilder s = new StringBuilder("" + num);
        s.reverse();
        return Integer.parseInt(s.toString());
    }
}