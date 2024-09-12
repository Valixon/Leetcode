import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L_1481 {
    private static byte[] bytes;

    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{5, 3, 4}, 3));
        System.out.println(findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }


    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr.length == k) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] a = new int[map.size()];
        int index = 0;
        for (Integer x : map.values()) {
            a[index++] = x;
        }
        Arrays.sort(a);
        int size = map.size();
        index = 0;
        int x = a[index];
        while (k >= x) {
            k = k - x;
            index++;
            x = a[index];
        }
        return size - index;
    }
}
