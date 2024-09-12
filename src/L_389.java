import java.util.Scanner;

public class L_389 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println((int) 'a');
        String s= "405870******4678";
        s = s.replaceAll("(\\d{4})(\\S{4})(\\S{4})(\\d{4})", "$1 $2 $3 $4");
        System.out.println(s);
        System.out.println(findTheDifference(sc.next(), sc.next()));
    }

    public static char findTheDifference(String s, String t) {
        int[] a = new int[26];
        for (char i : s.toCharArray()) {
            a[i - 97]++;
        }
        for (char i : t.toCharArray()) {
            a[i - 97]--;
        }
        for (int i = 1; i <= 26; i++) {
            if (a[i] == -1) {
                return (char) (i + 97);
            }
        }
        return 'a';
    }
}
