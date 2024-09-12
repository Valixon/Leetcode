import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class L_34 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        System.out.println(maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}));
//        System.out.println(maxDotProduct(new int[]{-1, -1}, new int[]{1, 1}));
//        System.out.println(maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}));

    }

    public static int[] searchRange(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        int q = list.indexOf(target);
        int q1 = list.lastIndexOf(target);
        return new int[]{q, q1};

    }
}