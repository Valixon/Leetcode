import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class L_1337 {
    private static boolean[] bordimi;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println(Arrays.toString(kWeakestRows(a, k)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        int n = mat.length;
        int[] b = new int[n];
        TreeSet<Integer> salom = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                b[i] += mat[i][j];
            }
            salom.add(b[i]);
        }
        int index = 0;
        for (Integer a : salom) {
            for (int i = 0; i < n; i++) {
                if (a == b[i]) {
                    res[index] = i;
                    index++;
                    if (index == k) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}

/*
6
1
    1
3
    0 2 4
2
    1 3
1
    2
2
    1 5
1
    4


5
4
1 2 3 4
1
0
1
0
1
0
1
0

5
1
1
3
0 2 4
3
1 3  4
1
2
2
1 2




 */

