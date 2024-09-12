public class L_1143 {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        for (int i = 0; i < t1.length; i++) {
            for (int j = 0; j < t2.length; j++) {
                if (t1[i] == t2[j]) {
                    if (i * j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    dp[i][j] = Math.max(i == 0 ? 0 : dp[i - 1][j], j == 0 ? 0 : dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }
}
