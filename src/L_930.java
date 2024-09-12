import java.util.ArrayList;
import java.util.List;

public class L_930 {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0, 1, 0}, 0));
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0, 1, 0, 1}, 0));
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));

    }


    public static int numSubarraysWithSum(int[] nums, int goal) {
        List<Integer> birlar = new ArrayList<>();
        birlar.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) birlar.add(i + 1);
        }
        birlar.add(nums.length + 1);
        int n = birlar.size();
        int[] p = new int[birlar.size()];
        for (int i = 0; i < birlar.size(); i++) {
            p[i] = birlar.get(i);
        }
        int sum = 0;
        if (goal == 0) {
            for (int i = 1; i < n; i++) {
                int r = (p[i] - p[i - 1] - 1);
                sum = sum + ((r * (r + 1)) / 2);
            }
            return sum;
        } else {
            for (int i = 1; i < n - goal; i++) {
                int r = (p[i] - p[i - 1]);
                int t = (p[i + goal] - p[i + goal - 1]);
                sum = sum + (r * t);
            }
            return sum;
        }
    }
}