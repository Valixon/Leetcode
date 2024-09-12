public class L_791 {
    public static void main(String[] args) {
        System.out.println(customSortString("cba","abcd"));
    }

    public static String customSortString(String order, String s) {
        char[] pat = order.toCharArray();
        char[] str = s.toCharArray();
        sortByPattern(str, pat);
        return String.valueOf(str);
    }

    static int MAX_CHAR = 26;

    static void sortByPattern(char[] str, char[] pat) {
        int count[] = new int[MAX_CHAR];

        for (int i = 0; i < str.length; i++) {
            count[str[i] - 'a']++;
        }
        int index = 0;
        for (int i = 0; i < pat.length; i++) {
            for (int j = 0; j < count[pat[i] - 'a']; j++) {
                str[index++] = pat[i];
            }
        }
    }
}