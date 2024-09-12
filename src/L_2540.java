import java.util.Set;
import java.util.TreeSet;

public class L_2540 {
    public static void main(String[] args) {

    }

    public int getCommon(int[] nums1, int[] nums2) {
        int min = -1;
        Set<Integer> a1 = new TreeSet<>();
        for (int i : nums1) a1.add(i);
        for (int i : nums2) {
            if (a1.contains(i)) {
                min = i;
                break;
            }
        }
        a1 = new TreeSet<>();
        for (int i : nums2) a1.add(i);
        for (int i : nums1) {
            if (a1.contains(i)) {
                min = Math.min(min, i);
                break;
            }
        }
        return min;
    }
}
/*

5
3 4 1 1 0 0

9
1 1 1 1 1 1 1 1 7 1

6
4 1 1 1 1 2 1

35

1 0 4 0 4 1 4 3 1 1 1 2 1 4 0 3 0 3 0 3 0 5 3 0 0 1 2 1 2 4 3 0 1 0 5 2
 */