public class L_1160 {
    public static int daraja;

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }

    public static int countCharacters(String[] words, String chars) {
        int sum = 0;
        int[] a = new int['z' + 1];
        for (char i : chars.toCharArray()) {
            a[i]++;
        }
        for (String word : words) {
            if (ichindamii(word, a.clone())) {
                sum += word.length();
            }
        }
        return sum;
    }

    public static boolean ichindamii(String word, int[] a) {
        for (int i = 0; i < word.length(); i++) {
            if (--a[word.charAt(i)] == -1) return false;
        }
        return true;
    }
}