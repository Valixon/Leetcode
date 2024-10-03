import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L_1590 {
    public static void main(String[] args) {
//        System.out.println(minSubarray(new int[]{3, 1, 4, 2}, 6));
//        System.out.println(minSubarray(new int[]{6, 3, 5, 2}, 9));
//        System.out.println(minSubarray(new int[]{1, 2, 3}, 3));
//        System.out.println(minSubarray(new int[]{4, 4, 2}, 7));
        System.out.println(minSubarray(new int[]{3, 6, 8, 1}, 8));
    }


    public static int minSubarray(int[] nums, int p) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        long sum = 0;
        for (int num : nums) {
            sum += (num * 1l);
            a.add(num % p);
        }
        if (sum < p) return -1;
        if (sum % p == 0) return 0;
        int q = (int) (sum % p);
        int res = 1;
        while (!(a.contains(q)) && !a.isEmpty()) {
            b = new LinkedList<>();
            int index = 0;
            for (int i = res; i < nums.length; i++) {
                b.add((a.get(index) + nums[i]) % p);
                index++;
            }
            a = b;
            res++;
        }
        if (a.isEmpty()) return -1;
        return res;
    }
}
