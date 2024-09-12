import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L_1048 {
    private static int[] uzunlik;
    public static List<String> boladi = new ArrayList<>();
    public static List<String> bolmaydi = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
        System.out.println(longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}));
        System.out.println(longestStrChain(new String[]{"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"}));

    }

    public static int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        uzunlik = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (uzunlik[i] == 0) {
                uzunlik[i] = hisobla(i, words);
                max = Math.max(max, uzunlik[i]);
            }
        }
        return max;
    }

    public static int hisobla(int index, String[] words) {
        int q = uzunlik[index];
        if (q != 0) {
            return q;
        }
        q = 1;
        for (int i = index + 1; i < words.length; i++) {
            if (bolami(words[index], words[i])) {
                q = Math.max(q, 1 + hisobla(i, words));
            }
        }
        uzunlik[index] = q;
        return uzunlik[index];
    }

    public static boolean bolami(String word, String word1) {
        if (boladi.contains(word + " " + word1)) {
            return true;
        }
        if (bolmaydi.contains(word + " " + word1)) {
            return false;
        }
        if (word.length() + 1 == word1.length()) {
            int r = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != word1.charAt(i + r)) {
                    r++;
                    i--;
                    if (r == 2) {
                        bolmaydi.add(word + " " + word1);
                        return false;
                    }
                }
            }
            boladi.add(word + " " + word1);
            return true;
        }
        bolmaydi.add(word + " " + word1);
        return false;
    }

}