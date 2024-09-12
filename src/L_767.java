import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L_767 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(reorganizeString(sc.next()));
    }

    public static String reorganizeString(String s) {
        if (s.length() == 1) return s;
        String result = "";
        int[] a = new int[26];
        int max = 0;
        int r;
        for (int i = 0; i < s.length(); i++) {
            r = s.charAt(i) - 97;
            a[r]++;
            max = Math.max(max, a[r]);
            if (max > (s.length() + 1) / 2) {
                return result;
            }
        }
        int[] b = Arrays.copyOf(a, a.length);
        int[] c = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        List<Character> l1 = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {
            if (b[i] == 0) break;
            for (int j = 0; j <= 25; j++) {
                if (b[i] == a[j]) {
                    for (int k = 0; k < b[i]; k++) {
                        l1.add((char) (j + 97));
                    }
                    a[j] = 0;
                    break;
                }
            }
        }
        StringBuilder s2 = new StringBuilder();
        int y = 0;
        int q = l1.size() / 2;
        for (int i = 0; i < q; i++) {
            if (l1.get(0) == (l1.get(l1.size() - 1))) {
                y = l1.get(0);
                break;
            }
            s2.append(l1.get(0)).append(l1.get(l1.size() - 1));
            l1.remove(l1.size() - 1);
            l1.remove(0);
        }
        if (l1.isEmpty()) {
            return s2.toString();
        }
        if (s2.charAt(s2.length() - 1) != l1.get(0)) {
            s2.append(l1.get(0));
            l1.remove(0);
        }
        if (l1.isEmpty()) {
            return s2.toString();
        }
        int e = l1.size();
        byte rr = 0;
        if (s2.charAt(0) == l1.get(0)) {
            rr = 2;
        }
        while (e > 0) {
            e--;
            s2.insert(rr, (char) l1.get(0));
            rr += 2;
        }
        return s2.toString();
    }
}
// 8 3    1 3 -1 -3 5 3 6 7