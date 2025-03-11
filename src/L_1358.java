public class L_1358 {
    private static byte[] bytes;

    public static void main(String[] args) {
//        System.out.println(numberOfSubstrings("abcabc"));
//        System.out.println(numberOfSubstrings("aaacb"));
//        System.out.println(numberOfSubstrings("ababbbc"));
        System.out.println(numberOfSubstrings("acbbcac"));
    }


    public static int numberOfSubstrings(String s) {
        int start = 0, end = 3;
        byte[] bytes = s.getBytes();
        int n = bytes.length;
        int[] alphabet = new int[3];
        int count = 0;

        for (int i = start; i < end; i++) {
            alphabet[bytes[i] - 'a']++;
        }

        while (start < end) {
            if (isAll(alphabet)) {
                count += n - end + 1;
                alphabet[bytes[start] - 'a']--;
                start++;
            } else {
                if (end >= n) return count;
                alphabet[bytes[end] - 'a']++;
                end++;
            }
        }

        return count;
    }

    static boolean isAll(int[] alphabet) {
        for (int i : alphabet) {
            if (i <= 0) {
                return false;
            }
        }
        return true;
    }
}
