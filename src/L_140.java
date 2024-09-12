import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L_140 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> a = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a.add(sc.next());
        }
        System.out.println(wordBreak(s, a));
    }

    public static List<String> res = new ArrayList<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        salom(s, wordDict, "");
        return res;
    }

    private static void salom(String s, List<String> wordDict, String p) {
        if (s.isEmpty()) {
            res.add(p.trim());
        }
        for (int i = 1; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            if (wordDict.contains(s1)) {
                salom(s.substring(i), wordDict, p + " " + s1);
            }
        }
    }
}

