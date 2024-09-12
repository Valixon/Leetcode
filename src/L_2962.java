import java.util.ArrayList;
import java.util.List;

public class L_2962 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
        System.out.println(countSubarrays(new int[]{61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82, 10, 82, 78, 15, 82}, 2));
//        System.out.println(countSubarrays(new int[]{1, 4, 2, 1}, 3));
//        System.out.println(countSubarrays(new int[]{5, 5, 5, 5, 5, 5, 5}, 4));
//        System.out.println(countSubarrays(new int[]{5, 5, 5, 5, 5, 5, 5}, 1));
    }


    public static long countSubarrays(int[] nums, int k) {
        int max = 1;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        List<Integer> indexlar = new ArrayList<>();
        indexlar.add(-1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                indexlar.add(i);
            }
        }
        long sum = 0;
        indexlar.add(nums.length);
        for (int i = 1; i < indexlar.size() - k; i++) {
            long x = (long) (indexlar.get(i) - indexlar.get(i - 1)) * (nums.length - indexlar.get(i + k - 1));
            sum += x;
        }
        return sum;
    }
}
