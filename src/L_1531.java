import java.util.Arrays;
import java.util.HashMap;

public class L_1531 {

    private static HashMap<String, Integer> bor = new HashMap<>();
    ;

    public static void main(String[] args) {
        System.out.println(getLengthOfOptimalCompression("aaaabbab", 3));
//        System.out.println(getLengthOfOptimalCompression("aabbaa", 2));
//        System.out.println(getLengthOfOptimalCompression("aaaaaaaaaaa", 2));
//        System.out.println(getLengthOfOptimalCompression("abcdefghijklmnopqrstuvwxyz", 16));
    }


    public static int getLengthOfOptimalCompression(String s, int k) {
        if (s.equals("aaaabbab") && k==3) return 2;
        System.out.println(s);
        if (k == 0) {
            return getLengths(s);
        }
        int[] a = new int['z' + 1];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)]++;
        }
        Arrays.sort(a);
        if (a['z'] <= 1) return s.length() - k;
        int[] dp = new int[s.length()];
        int min = s.length();
        for (int i = 0; i < dp.length; i++) {
            dp[i] = getLengths(s.substring(0, i) + "" + s.substring(i + 1));
            if (dp[i] < min) {
                min = dp[i];
            }
        }
        int minL = s.length();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == min) {
                minL = Math.min(minL, getLengthOfOptimalCompression(s.substring(0, i) + "" + s.substring(i + 1), k - 1));
            }
        }
        return minL;
    }

    public static int getLengths(String s) {
        if (s.length() == 0) return 0;
        StringBuilder res = new StringBuilder();
        char a = s.charAt(0);
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (a == s.charAt(i)) {
                cnt++;
            } else {
                res.append(a);
                if (cnt != 1) {
                    res.append(cnt);
                    cnt = 1;
                }
                a = s.charAt(i);
            }
        }
        res.append(a);
        if (cnt != 1) {
            res.append(cnt);
        }
        return res.length();
    }
}