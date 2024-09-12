public class L_1582 {
    public static void main(String[] args) {
        int[][] a = new int[3][3];
        a[0] = new int[]{1, 0, 0};
        a[1] = new int[]{0, 0, 1};
        a[2] = new int[]{1, 0, 0};
        System.out.println(numSpecial(a));
//        System.out.println(maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}));
//        System.out.println(maxDotProduct(new int[]{-1, -1}, new int[]{1, 1}));
//        System.out.println(maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}));

    }


    public static int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] an = new int[n];
        int[] am = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    an[i] += mat[i][j];
                    am[j] += mat[i][j];
            }
        }
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (an[i] == 1) x++;
        }
        for (int i = 0; i < m; i++) {
            if (am[i] == 1) y++;
        }
        if (n > m) {

        } else {

        }
        return Math.min(x, y);
    }
}