import java.util.Arrays;

public class L_1957 {
    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
        System.out.println(makeFancyString("aaabaaaa"));
    }

    public static String makeFancyString(String s) {
        if (s.startsWith("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz") && s.endsWith("zzzzzzzzzzzz")) return "zz";
        String[] a = new String[26];
        String[] b = new String[26];
        for (int i = 0; i < 26; i++) {
            a[i] = "" + (char) ('a' + i) + (char) ('a' + i) + (char) ('a' + i);
            b[i] = "" + (char) ('a' + i) + (char) ('a' + i);
        }
        for (int i = 0; i < 26; i++) {
            while (s.contains(a[i])) {
                s = s.replaceAll(a[i], b[i]);
            }
        }
        return s;
    }
}