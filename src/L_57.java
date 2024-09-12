import java.util.Arrays;
import java.util.LinkedList;

public class L_57 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{2, 3})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{0, 100})));

    }


    public static int[][] insert(int[][] a, int[] b) {
        int n = a.length;
        if (n == 0) return new int[][]{{b[0], b[1]}};
        LinkedList<Integer> boshi = new LinkedList<>();
        LinkedList<Integer> oxiri = new LinkedList<>();
        if (a[0][0] >= b[0] && a[n - 1][1] <= b[1]) {
            return new int[][]{{b[0], b[1]}};
        }
        int index = n;
        for (int i = 0; i < n; i++) {
            if (a[i][0] <= b[0] && a[i][1] >= b[0]) {
                boshi.add(Math.min(a[i][0], b[0]));
                oxiri.add(Math.max(a[i][1], b[1]));
                index = i + 1;
                break;
            }
            boshi.add(Math.min(a[i][0], b[0]));
            oxiri.add(a[i][1]);
        }
        for (int i = index; i < n; i++) {
            if (a[i][1] < oxiri.getLast()) {
            } else if (a[i][0] == oxiri.getLast()) {
                oxiri.removeLast();
                oxiri.add(a[i][1]);
            } else {
                index = i;
                break;
            }
        }
        for (int i = index; i < n; i++) {
            boshi.add(a[i][0]);
            oxiri.add(a[i][1]);
        }
        if (oxiri.getLast() <= b[0]) {
            boshi.add(b[0]);
            oxiri.add(b[1]);
        }
        int[][] res = new int[boshi.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = boshi.get(i);
            res[i][1] = oxiri.get(i);
        }
        return res;
    }
}