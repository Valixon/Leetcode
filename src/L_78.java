import java.util.ArrayList;
import java.util.List;

public class L_78 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{0}));
        System.out.println(subsets(new int[]{3, 4, 5, 6, 7, 8}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(b);
        for (int num : nums) {
            List<List<Integer>> a1 = new ArrayList<>();
            for (List<Integer> p : a) {
                List<Integer> o = new ArrayList<>(p);
                o.add(num);
                a1.add(o);
            }
            a.addAll(a1);
        }
        return a;
    }
}