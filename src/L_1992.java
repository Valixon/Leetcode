import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_1992 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findFarmland(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}})));
        System.out.println(Arrays.deepToString(findFarmland(new int[][]{{1, 1}, {1, 1}})));
        System.out.println(Arrays.deepToString(findFarmland(new int[][]{{0}})));
    }

    public static int[][] findFarmland(int[][] land) {
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int x1 = i, y1 = j;
                    int x2 = land.length, y2 = land[0].length;
                    for (int k = i; k < land.length; k++) {
                        if (land[k][j] == 0) {
                            x2 = k;
                            break;
                        }
                    }
                    for (int k = j; k < land[0].length; k++) {
                        if (land[i][k] == 0) {
                            y2 = k;
                            break;
                        }
                    }
                    a.add(Arrays.asList(x1, y1, x2 - 1, y2 - 1));
                    nollabTasha(x1, y1, x2, y2, land);
                }
            }
        }
        int[][] res = new int[a.size()][4];
        for (int i = 0; i < a.size(); i++) {
            res[i][0] = a.get(i).get(0);
            res[i][1] = a.get(i).get(1);
            res[i][2] = a.get(i).get(2);
            res[i][3] = a.get(i).get(3);
        }
        return res;
    }

    private static void nollabTasha(int x1, int y1, int x2, int y2, int[][] land) {
        for (int i = x1; i <= x2 - 1; i++) {
            for (int j = y1; j <= y2 - 1; j++) {
                land[i][j] = 0;
            }
        }
    }
}
