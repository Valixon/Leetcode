import java.util.List;

public class L_632 {
    public static void main(String[] args) {
    }


    public static int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        int left = nums.get(0).getFirst();
        int right = nums.get(0).getLast();
        for (List<Integer> list : nums) {
            left = Math.min(left, list.getFirst());
            right = Math.max(right, list.getLast());
        }
        System.out.println(left + " " + right);
        return res;
    }
}
