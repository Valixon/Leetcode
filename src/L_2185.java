import java.util.stream.IntStream;

public class L_2185 {
    public static void main(String[] args) {
        System.out.println(prefixCount(new String[]{"a", "aba", "ababa", "aa"}, "ab"));
    }

    public static int prefixCount(String[] words, String pref) {
        return (int) IntStream.range(0, words.length)
                .filter(i -> words[i].startsWith(pref))
                .count();
    }
}
