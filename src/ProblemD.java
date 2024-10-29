import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ProblemD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int dp[][] = new int[n + 1][3];
        byte[] a = s.getBytes();
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == 'F') {
                dp[i][0] = dp[i + 1][0] + 1;
                dp[i][1] = dp[i + 1][1];
                dp[i][2] = dp[i + 1][2];
            } else if (a[i] == 'R') {
                dp[i][1] = dp[i + 1][0] + dp[i + 1][1];
                dp[i][2] = dp[i + 1][2];
            } else {
                dp[i][2] = dp[i + 1][0] + dp[i + 1][2];
                dp[i][1] = dp[i + 1][1];
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        Set<Integer> res = new TreeSet<>();
//        res.add(dp[0][0] + dp[0][1] - dp[0][2]);
        int y = 0;
        int op = 1;
        for (int i = 0; i < n; i++) {
            if (a[i] == 'R') {
                res.add(y + dp[i + 1][1] - dp[i + 1][2] + (op * (dp[i + 1][0] + 1)));
                op = 1;
                res.add(y + dp[i + 1][1] - dp[i + 1][2] - dp[i + 1][0]);

            } else if (a[i] == 'L') {
                res.add(y + (op * (dp[i + 1][0] + 1)) + dp[i + 1][1] - dp[i + 1][2]);
                op = -1;
                res.add(y + dp[i + 1][0] + dp[i + 1][1] - dp[i + 1][2]);
            } else {
                res.add(y + dp[i + 1][1] - dp[i + 1][2] - dp[i + 1][0]);
                res.add(y + dp[i + 1][0] + dp[i + 1][1] - dp[i + 1][2]);
                y += op;
            }
        }
//        System.out.println(res);
        System.out.println(res.size());
    }
}