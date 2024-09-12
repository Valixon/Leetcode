import java.util.HashSet;
import java.util.Set;

public class L_2870 {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));
        System.out.println(minOperations(new int[]{2, 1, 2, 2, 3, 3}));
    }


    public static int minOperations(int[] nums) {
        int[] a = new int[1000001];
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            a[num]++;
            s.add(num);
        }
        int sum = 0;

        for (int num1 : s) {
            int num = a[num1];
            int asos = num / 3;
            int qoldiq = num % 3;
            if (qoldiq == 0) {
                sum += asos;

            } else if (qoldiq == 1) {
                if (asos == 0) return -1;
                sum += asos + 1;
            } else {
                sum += asos + 1;
            }
        }
        return sum;
    }
}