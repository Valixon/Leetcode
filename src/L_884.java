import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_884 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        s1 = s1 + " " + s2;
        String[] a = s1.split(" ");
        List<String> all = new ArrayList<>();
        List<String> unique = new ArrayList<>();
        for (String s : a) {
            if (all.contains(s)) {
                unique.remove(s);
                continue;
            }
            all.add(s);
            unique.add(s);
        }
        String[] res = new String[unique.size()];
        return unique.toArray(res);
    }
}