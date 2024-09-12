import java.util.HashSet;
import java.util.Set;

public class L_2053 {

    public static void main(String[] args) {
        System.out.println(kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2));
        System.out.println(kthDistinct(new String[]{"aaa", "aa", "a"}, 1));
        System.out.println(kthDistinct(new String[]{"a", "b", "a"}, 3));
    }

    public static String kthDistinct(String[] arr, int k) {
        Set<String> a = new HashSet<>();
        Set<String> b = new HashSet<>();
        for (String i : arr) {
            if (b.contains(i)) {
                a.remove(i);
                continue;
            }
            a.add(i);
            b.add(i);
        }
        if (a.size() < k) return "";
        for (String s : arr) {
            if (a.contains(s)) {
                k--;
                if (k == 0) {
                    return s;
                }
            }
        }
        return "";
    }
}
