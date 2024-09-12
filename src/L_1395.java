import java.util.Scanner;

public class L_1395 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(numTeams(new int[]{2, 5, 3, 4, 1}));
        System.out.println(numTeams(new int[]{2, 1, 3}));
        System.out.println(numTeams(new int[]{1, 2, 3, 4}));
    }

    public static int numTeams(int[] rating) {
        int n = rating.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    dp[i][0]++;
                } else {
                    dp[i][1]++;
                }

            }
            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i]) {
                    dp[i][2]++;
                } else {
                    dp[i][3]++;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (dp[i][0] * dp[i][3]);
            sum += (dp[i][1] * dp[i][2]);
        }
        return sum;
    }
}
