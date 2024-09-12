public class L_514 {
    public static void main(String[] args) {
        System.out.println(findRotateSteps("abcde", "ade"));
//        System.out.println(findRotateSteps("godding", "godding"));
    }

    public static int findRotateSteps(String ring, String key) {
        int n = ring.length();
        char[] a = ring.toCharArray();
        char[] k = key.toCharArray();
        int[] dp = new int[a.length];
        for (int i = 0; i < n; i++) {
            if (a[i] == k[0]) {
                dp[i] = Math.min(i, n - i) + 1;
            }
        }
        for (int i = 1; i < k.length; i++) {
            char cur = k[i];
            char oldingi = k[i - 1];
            for (int r = 0; r < n; r++) {
                if (a[r] == cur) {
                    dp[r] = topibKel(a, r, oldingi, dp);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        char last = k[k.length - 1];
        for (int r = 0; r < n; r++) {
            if (a[r] == last) {
                res = Math.min(res, dp[r]);
            }
        }
        return res;
    }

    private static int topibKel(char[] a, int r, char k, int[] dp) {
        int min = Integer.MAX_VALUE;
        int n = a.length;
        for (int i = r; i >= 0; i--) {
            if (a[i] == k) {
                min = Math.min(min, dp[i] + Math.min(r - i, n - r + i) + 1);
            }
        }
        for (int i = r; i < n; i++) {
            if (a[i] == k) {
                min = Math.min(min, dp[i] + Math.min(i - r, n - i + r) + 1);
            }
        }
        return min;
    }
}
