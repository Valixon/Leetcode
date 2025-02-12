import java.util.Arrays;

public class L_684 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{{37, 40}, {18, 28}, {5, 37}, {14, 19}, {5, 46}, {15, 48}, {27, 42}, {1, 44}, {12, 33}, {29, 50}, {1, 7}, {26, 37}, {1, 15}, {24, 32}, {32, 46}, {4, 17}, {9, 37}, {6, 31}, {13, 38}, {39, 43}, {22, 45}, {30, 43}, {36, 50}, {7, 47}, {29, 35}, {19, 23}, {34, 37}, {2, 16}, {10, 21}, {1, 21}, {4, 49}, {12, 21}, {38, 42}, {8, 48}, {10, 48}, {17, 22}, {7, 50}, {17, 25}, {19, 50}, {6, 13}, {3, 37}, {2, 13}, {11, 16}, {13, 40}, {20, 32}, {30, 46}, {4, 18}, {33, 38}, {24, 41}, {19, 45}})));
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));
    }


    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] count = new int[n + 1];
        for (int[] edge : edges) {
            count[edge[0]]++;
            count[edge[1]]++;
        }
        boolean bor = true;
        while (bor) {
            bor = false;
            for (int[] edge : edges) {
                if ((count[edge[0]] == 1 && count[edge[1]] > 0) || (count[edge[1]] == 1 && count[edge[0]] > 0)) {
                    count[edge[0]]--;
                    count[edge[1]]--;
                    bor = true;
                    break;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (count[edges[i][0]] >= 1 && count[edges[i][1]] >= 1) {
                return edges[i];
            }
        }
        return null;
    }
}
