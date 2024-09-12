public class L_2220 {
    public static void main(String[] args) {
        System.out.println(countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        boolean[] a = new boolean['z' + 1];
        for (char i : allowed.toCharArray()) {
            a[i] = true;
        }
        int res = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!a[word.charAt(i)]) {
                    res--;
                    break;
                }
            }
            res++;
        }
        return res;
    }
}