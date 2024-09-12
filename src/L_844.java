public class L_844 {
    public static void main(String[] args) {
//        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
//        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public static boolean backspaceCompare(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            i = Math.max(i,0);
            if (s.charAt(i) == '#') {
                s = s.substring(0, Math.max(0, i - 1)) + s.substring(i + 1);
                i--;
                i--;
            }
        }
        for (int i = 0; i < t.length(); i++) {
            i = Math.max(i,0);
            if (t.charAt(i) == '#') {
                t = t.substring(0, Math.max(0, i - 1)) + t.substring(i + 1);
                i--;
                i--;
            }
        }
        return s.equals(t);
    }
}