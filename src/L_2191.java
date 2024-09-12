import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class L_2191 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortJumbled(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}, new int[]{991, 338, 38})));
    }

    private static int[] sonlar;
    private static Map<Integer, Integer> pos = new TreeMap<>();

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        sonlar = mapping;
        nums = Arrays.stream(nums).
                boxed().
                sorted((a, b) -> hayda(a).compareTo(hayda(b))). // sort descending
                        mapToInt(i -> i).
                toArray();
        return nums;
    }

    private static Integer hayda(Integer num) {
        if (pos.containsKey(num)) return pos.get(num);
        int qw = num;
        if (num == 0)
            return sonlar[0];
        int res = 0;
        int i = 1;
        while (num > 0) {
            res += sonlar[num % 10] * i;
            num /= 10;
            i *= 10;
        }
        pos.put(qw, res);
        return res;
    }
}