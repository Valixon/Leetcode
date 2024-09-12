import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_350 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        short[] a = new short[1001];
        List<Short> res = new ArrayList<>();
        for (int i : nums1) a[i]++;
        for (int i : nums2) {
            a[i]--;
            if (a[i] >= 0) {
                res.add((short) i);

            }

        }
        int[] javob = new int[res.size()];
        int index = 0;
        for (short i : res) {
            javob[index++] = i;
        }
        return javob;
    }
}