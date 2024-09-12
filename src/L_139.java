import java.util.*;

public class L_139 {
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

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> strings = new HashSet<>();
        Set<String> strings2 = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            strings.add(s.charAt(i) + "");
        }
        for (String s1 : wordDict) {
            for (int i = 0; i < s1.length(); i++) {
                strings2.add(s1.charAt(i) + "");
            }
        }
        strings.removeAll(strings2);
        if (!strings.isEmpty()) {
            return false;
        }
        return salom(s, wordDict, new ArrayList<>());
    }

    private static boolean salom(String s, List<String> wordDict, ArrayList<String> falseList) {
        if (falseList.contains(s)) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            if (wordDict.contains(s1)) {
                if (salom(s.substring(i), wordDict, falseList)) {
                    return true;
                }
                falseList.add(s.substring(i));
            }
        }
        return false;
    }
}
