import java.util.ArrayList;
import java.util.List;

public class L_119 {
    public static void main(String[] args) {
        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
        System.out.println(getRow(5));
    }

    public static List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex + 2][rowIndex + 2];
        dp[0][0] = 1;
        for (int i = 1; i <= rowIndex + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= rowIndex + 1; i++) {
            res.add(dp[rowIndex + 1][i]);
        }
        return res;
    }
}