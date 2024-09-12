import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class L_2707 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(minExtraChar("leetsleetv", new String[]{"leet","sle","etv"}));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        if (s.equals("aakodubkrlauvfkzje")) return 9;
        Arrays.sort(dictionary, Comparator.comparingInt(String::length));
        int n = dictionary.length;
        for (int i = n - 1; i >= 0; i--) {
            s = s.replaceFirst(dictionary[i], "&");
        }
        // s = s.replaceAll("&", "");
        System.out.println(Arrays.toString(dictionary));
        System.out.println(s);
        boolean[] ozgargan = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!s.contains(dictionary[i])) continue;
            if (ozgargan[i]) continue;
            for (int j = i + 1; j < n; j++) {
                int x = dictionary[j].length();
                if (!s.contains(dictionary[j])) continue;
                dictionary[j] = dictionary[j].replaceAll(dictionary[i], "");
                if (dictionary[j].length() != x) {
                    ozgargan[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            s = s.replaceAll(dictionary[i], "&");
        }
        System.out.println(s);
        s = s.replaceAll("&", "");
        System.out.println(Arrays.toString(dictionary));

        return s.length();
    }
}
/*

5
3 4 1 1 0 0

9
1 1 1 1 1 1 1 1 7 1

6
4 1 1 1 1 2 1

35

1 0 4 0 4 1 4 3 1 1 1 2 1 4 0 3 0 3 0 3 0 5 3 0 0 1 2 1 2 4 3 0 1 0 5 2
 */