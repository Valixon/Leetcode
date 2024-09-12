import java.util.ArrayList;
import java.util.List;

public class L_2812 {
    public static void main(String[] args) {
        List<List<Integer>> a = new ArrayList<>();
        a.add(List.of(0, 0, 0, 1));
        a.add(List.of(0, 0, 0, 0));
        a.add(List.of(0, 0, 0, 0));
        a.add(List.of(1, 0, 0, 0));
        System.out.println(maximumSafenessFactor(a));
    }


    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] a = new int[n][n];
        int[][] b = new int[n + 2][n + 2];
        for (int i = 0; i <= n + 1; i++) {
            b[i][0] = 200000;
            b[i][n + 1] = 200000;
            b[0][i] = 200000;
            b[n + 1][i] = 200000;
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = grid.get(i);
            for (int j = 0; j < n; j++) {
                a[i][j] = list.get(j);
                b[i + 1][j + 1] = a[i][j] - 1;
            }
        }
        hisobla(1, 1, b);

        return Math.max(Math.min(b[1][1], b[n + 1][n + 1]) - 1, 0);
    }

    private static int hisobla(int indexI, int indexJ, int[][] b) {
        if (b[indexI][indexJ] == 200000) return 200000;
        if (b[indexI][indexJ] == 0) return 0;
        b[indexI][indexJ] = 160000;
        if (b[indexI - 1][indexJ] == -1) {
            b[indexI - 1][indexJ] = hisobla(indexI - 1, indexJ, b);
        }
        if (b[indexI + 1][indexJ] == -1) {
            b[indexI + 1][indexJ] = hisobla(indexI + 1, indexJ, b);
        }
        if (b[indexI][indexJ - 1] == -1) {
            b[indexI][indexJ - 1] = hisobla(indexI, indexJ - 1, b);
        }
        if (b[indexI][indexJ + 1] == -1) {
            b[indexI][indexJ + 1] = hisobla(indexI, indexJ + 1, b);
        }
        b[indexI][indexJ] = 1 + Math.min(Math.min(b[indexI - 1][indexJ], b[indexI + 1][indexJ]), Math.min(b[indexI][indexJ - 1], b[indexI][indexJ + 1]));
        return b[indexI][indexJ];
    }
}