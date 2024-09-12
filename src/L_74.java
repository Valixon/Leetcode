import java.util.Scanner;

public class L_74 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int target = sc.nextInt();
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(searchMatrix(a, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = m - 1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] <= target && matrix[i][n-1] >= target) {
                x = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[x][i] == target) {
                return true;
            }
        }

        return false;
    }
}
