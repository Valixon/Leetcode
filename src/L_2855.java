import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class L_2855 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> a = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        System.out.println(minimumRightShifts(a));
    }

    public static int minimumRightShifts(List<Integer> nums) {
        List<Integer> sorrt = new ArrayList<>(nums);
        Collections.sort(sorrt);
        if (sorrt.equals(nums)) {
            return 0;
        }
        int n = nums.size();
        int idex = n - 1;
        while (idex > 0) {
            idex--;
            int q = nums.get(n - 1);
            nums.remove(n - 1);
            nums.add(0, q);
            if (sorrt.equals(nums)) {
                return n - idex-1;
            }
        }
        return -1;
    }
}
