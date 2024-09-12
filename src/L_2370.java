public class L_2370 {
    public static void main(String[] args) {
        System.out.println(longestIdealString("acfgbd", 2));
        System.out.println(longestIdealString("abcd", 3));
        System.out.println(longestIdealString("eduktdb", 15));
    }

    public static int longestIdealString(String s, int k) {
        int n = s.length();
        byte[] bytes = new byte[n];
        s.getBytes(0, n, bytes, 0);
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (Math.abs(bytes[i] - bytes[index]) <= k) {
                max++;
                dp[i] = max;
                index = i;
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (Math.abs(bytes[j] - bytes[i]) <= k) {
                    dp[i] = dp[j];
                    break;
                } else {
                    dp[i] = dp[j];
                }
            }
            dp[i] += 1;
            if (max < dp[i]) {
                max = dp[i];
                index = i;
            }
        }
        return max;
    }
}
