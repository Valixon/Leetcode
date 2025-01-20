public class L_2661 {
    public static void main(String[] args) {
        System.out.println(firstCompleteIndex(new int[]{1, 3, 4, 2}, new int[][]{{1, 4}, {2, 3}}));
        System.out.println(firstCompleteIndex(new int[]{2, 8, 7, 4, 1, 3, 5, 6, 9}, new int[][]{{3, 2, 5}, {1, 4, 6}, {8, 7, 9}}));
    }

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int index = 0;
        int n = mat.length;
        int m = mat[0].length;
        int q = arr.length;
        int[][] a = new int[q + 1][];
        int[] aa = new int[n];
        int[] bb = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[mat[i][j]] = new int[]{i, j};
            }
        }
        for (int i = 0; i < q; i++) {
            int[] p = a[arr[i]];
            aa[p[0]]++;
            bb[p[1]]++;
            if (aa[p[0]] == m || bb[p[1]] == n) return i;
        }
        return index;
    }
}
