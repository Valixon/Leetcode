import java.util.Scanner;

public class L_799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(champagneTower(sc.nextInt(), sc.nextInt(), sc.nextInt()));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] yechimcha = new double[query_row + 1][query_row + 1];
        yechimcha[0][0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (yechimcha[i - 1][j] > 1) {
                    yechimcha[i][j] += (yechimcha[i - 1][j] - 1) / 2;
                }
                if (j != 0 && yechimcha[i - 1][j - 1] > 1) {
                    yechimcha[i][j] += (yechimcha[i - 1][j - 1] - 1) / 2;
                }
            }
        }
        return Math.min(1, yechimcha[query_row][query_glass]);
    }
}
