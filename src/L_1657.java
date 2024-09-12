import java.util.Arrays;

public class L_1657 {
    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));
        System.out.println(closeStrings("a", "aa"));
        System.out.println(closeStrings("cabbba", "cabbba"));
        System.out.println(closeStrings("aabbczz", "abbczzz"));

    }

    public static boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        if (n != word2.length())  return false;
        if (word1.equals(word2))  return true;

        int[] s1 = new int[26];
        int[] s2 = new int[26];

        byte[] bytes = new byte[n];
        word1.getBytes(0, n, bytes, 0);
        for (byte i : bytes) {
            s1[i - 97]++;
        }
        word2.getBytes(0, n, bytes, 0);
        for (byte i : bytes) {
            s2[i - 97]++;
        }
        for (int i = 0; i <= 25; i++) {
            if ((s1[i] != 0 && s2[i] == 0) || (s1[i] == 0 && s2[i] != 0)) return false;
        }
        Arrays.sort(s1);
        Arrays.sort(s2);
        for (int i = 0; i <= 25; i++) {
            if (s1[i] != s2[i]) return false;
        }
        return true;
    }
}