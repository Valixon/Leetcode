import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class L_502 {

    public static void main(String[] args) {
        System.out.println(findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        System.out.println(findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
        System.out.println(findMaximizedCapital(3, 0, new int[]{4, 2, 3, 1, 9, 2}, new int[]{0, 1, 2, 1, 2, 3}));
    }


    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        ArrayList<Integer> p[] = new ArrayList[10001];
        TreeSet<Integer> raq = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            raq.add(profits[i]);
            if (p[profits[i]] == null) {
                p[profits[i]] = new ArrayList<>();
            }
            p[profits[i]].add(capital[i]);
        }
        for (int i = 10000; i >= 0; i--) {
            if (p[i] != null) {
                Collections.sort(p[i]);
            }
        }

        boolean bor = true;
        while (k > 0 && bor) {
            bor = false;
            for (int i : raq.descendingSet()) {
                ArrayList<Integer> o = p[i];
                if (!o.isEmpty()) {
                    int c = o.get(0);
                    if (c <= w) {
                        w += i;
                        k--;
                        bor = true;
                        p[i].remove(0);
                        break;
                    }
                }
            }
        }
        return w;
    }
}