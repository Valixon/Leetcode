import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class L_97 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isInterleave(sc.next(), sc.next(), sc.next()));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if ((s1 + s2).equals(s3)) return true;
        if ((s2 + s1).equals(s3)) return true;
        if (s1.length() + s2.length() != s3.length()) return false;
        Set<String> notInterleave = new HashSet<>();
        return salom(s1, s2, s3, notInterleave);
    }

    public static boolean salom(String s1, String s2, String s3, Set<String> notInterleave) {
        if (notInterleave.contains(s1 + ":" + s2) || notInterleave.contains(s2 + ":" + s1)) {
            return false;
        }
        if ((s1 + s2).equals(s3) || (s2 + s1).equals(s3)) return true;
        if (!s1.isEmpty() && s1.charAt(0) == s3.charAt(0)) {
            char a1 = s1.charAt(0);
            char a3 = s1.charAt(0);
            s1 = s1.substring(1);
            s3 = s3.substring(1);
            if (salom(s1, s2, s3, notInterleave)) {
                return true;
            } else {
                notInterleave.add(s1 + ":" + s2);
                s1 = "" + a1 + "" + s1;
                s3 = "" + a3 + "" + s3;
            }
        }
        if (s2.isEmpty()) {
            return s1.equals(s3);
        }
        boolean a = s2.charAt(0) == s3.charAt(0) && salom(s1, s2.substring(1), s3.substring(1), notInterleave);
        if (a) {
            return true;
        }
        notInterleave.add(s1 + ":" + s2.substring(1));
        return false;
    }
}
// This is an example of text justification.
// What must be acknowledgment shall be