import java.util.*;

public class L_1743 {
    public static void main(String[] args) {
        int[][] a = new int[3][2];
        a[0] = new int[]{2, 1};
        a[1] = new int[]{3, 4};
        a[2] = new int[]{3, 2};
        System.out.println(Arrays.toString(restoreArray(a)));
    }

    public static int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pair : adjacentPairs) {
            map.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            map.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        int start = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        result[0] = start;
        for (int i = 1; i < n; i++) {
            List<Integer> neighbors = map.get(result[i - 1]);
            result[i] = (i - 2 >= 0 && neighbors.get(0) == result[i - 2]) ? neighbors.get(1) : neighbors.get(0);
        }

        return result;
    }
}
