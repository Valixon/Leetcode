public class L_840 {

    public static void main(String[] args) {
        System.out.println(numMagicSquaresInside(new int[][]{{3, 10, 2, 3, 4}, {4, 5, 6, 8, 1}, {8, 8, 1, 6, 8}, {1, 3, 5, 7, 1}, {9, 4, 9, 2, 9}}));
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[] a = new boolean[10];
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                int a11 = grid[i][j];
                int a12 = grid[i][j + 1];
                int a13 = grid[i][j + 2];
                int a21 = grid[i + 1][j];
                int a22 = grid[i + 1][j + 1];
                int a23 = grid[i + 1][j + 2];
                int a31 = grid[i + 2][j];
                int a32 = grid[i + 2][j + 1];
                int a33 = grid[i + 2][j + 2];

                if (a11 + a12 + a13 == 15
                        && a21 + a22 + a23 == 15
                        && a11 + a21 + a31 == 15
                        && a12 + a22 + a32 == 15
                        && a11 + a22 + a33 == 15) {
                    a = new boolean[10];
                    if (a11 > 9) continue;
                    if (a12 > 9){ j++; continue;}
                    if (a13 > 9){ j+=2; continue;}
                    if (a21 > 9){ continue;}
                    if (a22 > 9){ j+=1; continue;}
                    if (a23 > 9){ j+=2; continue;}
                    if (a31 > 9){  continue;}
                    if (a32 > 9){ j+=1; continue;}
                    if (a33 > 9){ j+=2; continue;}
                    a[a11] = true;
                    a[a12] = true;
                    a[a13] = true;
                    a[a21] = true;
                    a[a22] = true;
                    a[a23] = true;
                    a[a31] = true;
                    a[a32] = true;
                    a[a33] = true;
                    boolean p = true;
                    for (int k = 1; k <= 9; k++) {
                        p = p & a[k];
                    }
                    if (!p) continue;
                    res++;
                }
            }
        }
        return res;
    }
}
// [3,10,2,3,4],
// [4,5,6,8,1],
// [8,8,1,6,8],
// [1,3,5,7,1],
// [9,4,9,2,9]