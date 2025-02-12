import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L_3160 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(queryResults(4, new int[][]{{1, 4}, {2, 5}, {1, 3}, {3, 4}})));
        System.out.println(Arrays.toString(queryResults(4, new int[][]{{0, 1}, {1, 2}, {2, 2}, {3, 4}, {4, 5}})));
    }


    public static int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        Map<Integer, Integer> son = new HashMap<>();
        Map<Integer, Integer> ranglar = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = queries[i][0];
            int rang = queries[i][1];
            if (son.containsKey(num)) {
                int oldRang = son.get(num);
                int count = ranglar.get(oldRang);
                if (count == 1) {
                    ranglar.remove(oldRang);
                } else {
                    ranglar.put(oldRang, count - 1);
                }
            }
            son.put(num, rang);
            Integer y = ranglar.get(rang);
            if (y == null) {
                y = 0;
            }
            y++;
            ranglar.put(rang, y);
            res[i] = ranglar.size();
        }

        return res;
    }
}
