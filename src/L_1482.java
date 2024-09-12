import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class L_1482 {

    private static List<List<Integer>> guruh = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
//        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        System.out.println(minDays(new int[]{7, 7, 7, 12, 7, 7, 7}, 2, 3));
    }


    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) return -1;
        TreeSet<Integer> a = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : bloomDay) {
            a.add(i);
            list.add(i);
        }
        if (a.size() == 1 || n == m * k) {
            return a.last();
        }
        if (m * k == 1) return a.first();
        int res = a.last();
        guruh = new ArrayList<>();
        guruh.add(list);
        for (Integer p : a.descendingSet()) {
            int size = ajratibtasha(p, k);
            if (size >= m) {
                res = p;
            } else {
                return p;
            }
        }
        return res;
    }

    private static int ajratibtasha(Integer p, int k) {
        int res = 0;
        List<List<Integer>> o = new ArrayList<>();
        for (List<Integer> kichik : guruh) {
            while (kichik.contains(p)) {
                List<Integer> u = kichik.subList(0, kichik.indexOf(p));
                res += u.size() / k;
                if (u.size() >= k) {
                    o.add(u);
                }
                kichik = kichik.subList(kichik.indexOf(p) + 1, kichik.size());
            }
            res += kichik.size() / k;
            if (kichik.size() >= k) {
                o.add(kichik);
            }
        }
        guruh = o;
        return res;
    }

    public static int findMaxInRange(int[] array, int from, int to) {
        int max = array[from];
        for (int i = from + 1; i < to; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }
}