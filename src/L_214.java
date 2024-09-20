public class L_214 {
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("abcd"));
    }

    public static String shortestPalindrome(String s) {
        if (s.isEmpty()) return "";
        int n = s.length();
        char[] array = s.toCharArray();
        char first = array[0];
        for (int i = n - 1; i >= 0; i--) {
            if (array[i] == first) {
                if (palindrome(array, i + 1)) {
                    StringBuilder res = new StringBuilder();
                    for (int j = i + 1; j < n; j++) {
                        res.insert(0, array[j]);
                    }
                    return res + "" + s;
                }
            }
        }
        return s;
    }

    private static boolean palindrome(char[] array, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (array[i] != array[n - 1 - i]) return false;
        }
        return true;
    }
}