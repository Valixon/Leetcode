import java.util.TreeMap;

public class L_2563 {
    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));
        System.out.println(countFairPairs(new int[]{1, 7, 9, 2, 5}, 11, 11));
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer[] a = map.keySet().toArray(new Integer[map.size()]);
        long res = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int val = map.get(a[i]);
            if (a[i] * 2 >= lower && a[i] * 2 <= upper) {
                res = ((val - 1) * val) / 2;
            }
            for (int j = i + 1; j < a.length; j++) {
                int ik = map.get(a[j]);
                int p = a[i] + a[j];
                if (p > upper) break;
                if (p < lower) continue;
                res += (val * ik);
            }
        }
        return res;
    }
}