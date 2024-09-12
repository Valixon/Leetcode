import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_368 {
    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8}));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8, 3, 9, 27, 81}));
    }


    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] indexlar = new int[n];
        int[] soni = new int[n];
        int max = 0;
        int maxIndex = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (nums[j] % nums[i] == 0) {
                    if (soni[i] < soni[j] + 1) {
                        soni[i] = soni[j] + 1;
                        indexlar[i] = j;
                    }
                }
            }
            if (soni[i] > max) {
                max = soni[i];
                maxIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (indexlar[maxIndex] != maxIndex) {
            res.add(nums[maxIndex]);
            maxIndex = indexlar[maxIndex];
        }
        res.add(nums[maxIndex]);
        return res;
    }
}
