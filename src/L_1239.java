import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L_1239 {
    private static int max = 0;

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("a");
        s.add("abc");
        s.add("d");
        s.add("de");
        s.add("def");
        System.out.println(maxLength(s));
    }

    public static int maxLength(List<String> arr) {
        List<String> s = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            Set<Character> x = new HashSet<>();
            for (char p : arr.get(i).toCharArray()) {
                x.add(p);
            }
            if (x.size() != arr.get(i).length()) {
                s.add(arr.get(i));
            }
        }
        arr.removeAll(s);
        for (int i = 0; i < arr.size(); i++) {
            boolean[] ishlatildi = new boolean['z' + 1];
            hisobla("", ishlatildi, arr.subList(i, arr.size()));
        }
        return max;
    }

    private static void hisobla(String current, boolean[] ishlatildi, List<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            boolean q = true;
            for (char p : s.toCharArray()) {
                if (ishlatildi[p]) {
                    q = false;
                    break;
                }
            }
            if (q) {
                for (char p : s.toCharArray()) {
                    ishlatildi[p] = true;
                }
                max = Math.max(max, (current + s).length());
                hisobla(current + s, ishlatildi, arr.subList(i + 1, arr.size()));
                for (char p : s.toCharArray()) {
                    ishlatildi[p] = false;
                }
            }
        }
    }
}