import java.util.Arrays;
import java.util.LinkedList;

public class L_260 {

    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 0})));
        System.out.println(Arrays.toString(singleNumber(new int[]{0, 1, 1, 2})));
    }


    public static int[] singleNumber(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        for (Integer i : nums) {
            if (res.contains(i)) {
                res.remove(i);
            } else {
                res.add(i);
            }
        }
        return new int[]{res.get(0), res.get(1)};
    }
}