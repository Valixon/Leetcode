public class L_1704 {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
        System.out.println(halvesAreAlike("textbook"));

    }

    public static boolean halvesAreAlike(String s) {
        s = s.toUpperCase();
        int[] a = new int['Z' + 1];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            a[chars[i]]++;
        }
        for (int i = chars.length / 2; i < chars.length; i++) {
            a[chars[i]]--;
        }
        int x = a['A'] + a['E'] + a['I'] + a['O'] + a['U'];
        return x == 0;
    }
}