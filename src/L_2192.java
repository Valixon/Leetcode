import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class L_2192 {
    public static void main(String[] args) {
        System.out.println(getAncestors(8, new int[][]{{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}}));
    }

    private static HashSet<Integer>[] a;
    private static boolean[] tayyormi;

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        a = new HashSet[n];
        tayyormi = new boolean[n];
        for (int[] edge : edges) {
            if (a[edge[1]] == null) {
                a[edge[1]] = new HashSet<>();
            }
            a[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!tayyormi[i]) {
                rekursiya(i);
            }

            List<Integer> sortedList = new ArrayList<>(a[i]);
            Collections.sort(sortedList);
            res.add(sortedList);
        }

        return res;
    }

    private static void rekursiya(int current) {
        if (a[current] == null) {
            a[current] = new HashSet<>();
            tayyormi[current] = true;
            return;
        }
        HashSet<Integer> res = new HashSet<>();
        for (Integer po : a[current]) {
            if (!tayyormi[po]) {
                rekursiya(po);
            }
            res.addAll(a[po]);
        }
        tayyormi[current] = true;
        a[current].addAll(res);
    }
}