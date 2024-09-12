import java.util.Arrays;
import java.util.LinkedList;

public class L_1785 {
    public static LinkedList<Integer> adj[];

    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
        System.out.println(sortVowels("lYmpH"));


    }

    public static String sortVowels(String s) {
        char[] a = s.toCharArray();
        char[] unlilar = new char[a.length];
        int idex = 0;
        for (int i = 0; i < a.length; i++) {
            if (unlimi(a[i])) {
                unlilar[idex++] = a[i];
                a[i] = '-';
            }
        }
        Arrays.sort(unlilar, 0, idex);
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (char ch : a) {
            if (ch == '-') {
                result.append(unlilar[index]);
                index++;
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static boolean unlimi(char ch) {
        return ch == 'a' || ch == 'A'
                || ch == 'e' || ch == 'E'
                || ch == 'i' || ch == 'I'
                || ch == 'o' || ch == 'O'
                || ch == 'u' || ch == 'U';
    }
}