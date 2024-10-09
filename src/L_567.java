public class L_567 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }


    public static boolean checkInclusion(String s1, String s2) {
        int[] a = new int['z' + 1];
        int[] b = new int['z' + 1];
        for (char i : s1.toCharArray())
            a[i]++;
        if (s1.length() > s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            b[s2.charAt(i)]++;
        }
        if (equalsA(a, b)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            b[s2.charAt(i)]++;
            b[s2.charAt(i - s1.length())]--;
            if (equalsA(a, b)) {
                return true;
            }
        }
        return false;
    }

    private static boolean equalsA(int[] a, int[] b) {
        for (char i = 'a'; i <= 'z'; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
