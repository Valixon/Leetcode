import java.util.Scanner;

public class ProblemH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long dp[] = new long[2001];
        dp[1]   = 1;
        dp[4]   = 2; dp[5]   = 1;
        dp[9]   = 2; dp[10] = 1;
        dp[40]  = 2; dp[50]  = 1;
        dp[90]  = 2; dp[100]  = 1;
        dp[400] = 2; dp[500] = 1;
        dp[900] = 2; dp[1000] = 1;

        for (int i = 1; i <= 2000; i++) {
            if (dp[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j <= i/2; j++) {
                    dp[i] = Math.min(dp[i - j] + dp[j], dp[i]);
                }
            }
        }
        if (n<=2000){
            System.out.println(dp[(int)n]);
            return;
        }
        System.out.println(Math.min((n / 2000) * 2 + dp[(int) (n % 2000)],(((n / 2000) -1) * 2)+1 + dp[1000+(int) (n % 2000)]));

    }

    private static long salom2(long n) {
        long dp[] = new long[16001];
        dp[1]   = 1;
        dp[4]   = 2; dp[5]   = 1;
        dp[9]   = 2; dp[10] = 1;
        dp[40]  = 2; dp[50]  = 1;
        dp[90]  = 2; dp[100]  = 1;
        dp[400] = 2; dp[500] = 1;
        dp[900] = 2; dp[1000] = 1;

        for (int i = 1; i <= 16000; i++) {
            if (dp[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j <= i/2; j++) {
                    dp[i] = Math.min(dp[i - j] + dp[j], dp[i]);
                }
            }
        }
        return (n / 16000) * 16 + dp[(int) (n % 16000)];
    }

    private static long salom(long n) {
        long dp[] = new long[4001];
        dp[1]   = 1;
        dp[4]   = 2; dp[5]   = 1;
        dp[9]   = 2; dp[10] = 1;
        dp[40]  = 2; dp[50]  = 1;
        dp[90]  = 2; dp[100]  = 1;
        dp[400] = 2; dp[500] = 1;
        dp[900] = 2; dp[1000] = 1;

        for (int i = 1; i <= 4000; i++) {
            if (dp[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j <= i/2; j++) {
                    dp[i] = Math.min(dp[i - j] + dp[j], dp[i]);
                }
            }
        }
        return (n / 4000) * 4 + dp[(int) (n % 4000)];
    }
}
