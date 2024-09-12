import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L_459 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(repeatedSubstringPattern(sc.next()));
    }

    public static boolean repeatedSubstringPattern(String s) {
        List<Integer> a = new ArrayList<>();
        String s2 = "";
        boolean salom = true;
        for (int i = s.length() / 2; i >= 1; i--) {
            if (s.length() % i != 0) continue;
            salom = true;
            for (Integer x : a) {
                if (x % i == 0) {
                    salom = false;
                    break;
                }
            }
            if (!salom) continue;
            a.add(i);
            s2 = s.substring(0, i);
            StringBuilder repeated = new StringBuilder();
            for (int j = 1; j < s.length() / i; j++) {
                repeated.append(s2);
            }
            if (repeated.toString().equals(s2)) {
                return true;
            }
        }
        return false;
    }
}
// 8 3    1 3 -1 -3 5 3 6 7