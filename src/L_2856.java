import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L_2856 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> a = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        System.out.println(minLengthAfterRemovals(a));
    }

    public static int minLengthAfterRemovals(List<Integer> nums) {
        int max = 1;
        int max2 = 0;
        int p = nums.get(0);
        for (Integer a : nums) {
            if (p == a) {
                max2++;
            } else {
                max = Math.max(max, max2);
                max2 = 1;
                p = a;
            }
        }
        max = Math.max(max, max2);

        int n = nums.size();
        if (n >= max * 2) {
            return n % 2 == 0 ? 0 : 1;
        }
        return max - (n - max);
    }
}
