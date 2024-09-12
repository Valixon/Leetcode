public class L_2486 {

    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
        System.out.println(appendCharacters("abcde", "a"));
        System.out.println(appendCharacters("z", "abcde"));
    }


    public static int appendCharacters(String s, String t) {
        t = t + " ";
        int n = s.length();
        int m = t.length();
        byte[] bytes = new byte[n];
        byte[] bytet = new byte[m];
        s.getBytes(0, n, bytes, 0);
        t.getBytes(0, m, bytet, 0);
        int current = 0;
        for (int i = 0; i < n; i++) {
            if (bytes[i] == bytet[current]) {
                current++;
            }
        }
        return m - current-1;
    }
}