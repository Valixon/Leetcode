import java.util.ArrayList;
import java.util.List;

public class L_310 {

    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
        System.out.println(findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(new Integer[]{0});
        if (n == 2) return List.of(edges[0][0], edges[0][1]);
        List<Integer>[] a = new List[n];
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            a[edges[i][0]].add(edges[i][1]);
            a[edges[i][1]].add(edges[i][0]);
        }
        int index = 0;
        List<Integer> maxYul = new ArrayList<>();
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (a[i].size() == 1) {
                index = i;
                boolean[] ishlatildi = new boolean[n];
                ishlatildi[index] = true;
                List<Integer> yul = new ArrayList<>();
                yul.add(index);
                count++;
                yulniQur(yul, index, ishlatildi, a);
                if (maxYul.size() < yul.size()) {
                    maxYul = yul;
                }
                if (count == 100) break;

            }
        }

        System.out.println(maxYul);
        return maxYul.subList((maxYul.size() - 1) / 2, (maxYul.size() + 2) / 2);
    }

    private static List<Integer> yulniQur(List<Integer> yul, int index, boolean[] ishlatildi, List<Integer>[] a) {
        boolean bor = false;
        for (Integer i : a[index]) {
            if (!ishlatildi[i]) {
                bor = true;
                break;
            }
        }
        if (!bor) return yul;
        List<Integer> res = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        for (Integer i : a[index]) {
            if (!ishlatildi[i]) {
                ishlatildi[i] = true;
                List<Integer> q = yulniQur(new ArrayList(List.of(i)), i, ishlatildi, a);
                if (res.size() <= q.size()) {
                    res2 = res;
                    res = q;
                }
            }
        }
        yul.addAll(res);
        return yul;
    }
}
