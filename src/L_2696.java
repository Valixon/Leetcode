public class L_2696 {
    public static void main(String[] args) {
    }


    public int minLength(String s) {
        int x = -1;
        while (x != s.length()) {
            x = s.length();
            s = s.replaceAll("AB", "");
            s = s.replaceAll("CD", "");
        }
        return s.length();
    }
}
