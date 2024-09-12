public class L_664 {
    public static void main(String[] args) {
        System.out.println(strangePrinter("aaabbb"));
        System.out.println(strangePrinter("abacda"));
        System.out.println(strangePrinter("baacdddaaddaaaaccbddbcabdaabdbbcdcbbbacbddcabcaaa"));
    }


    public static int strangePrinter(String s) {
        String s1 = "" + s.charAt(0);
        char lastChar = s.charAt(0);
        for (char i : s.toCharArray()) {
            if (lastChar == i) continue;
            s1 += "" + i;
            lastChar = i;
        }
        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];
        char[] p = s1.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i + 1] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 2] = 2;
        }
        for (int qadam = 3; qadam <= n; qadam++) {
            for (int i = 0; i <= n - qadam; i++) {
                dp[i][i + qadam] = qadam;
                for (int k = 1; k <= qadam; k++) {
                    dp[i][i + qadam] = Math.min(dp[i][i + qadam], dp[i][i + k] + dp[i + k][i + qadam]);
                }
                if (p[i] == p[i + qadam - 1]) dp[i][i + qadam]--;
            }
        }
        return dp[0][n];
    }
}