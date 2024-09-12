public class L_242 {
    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println(isAnagram("anagram", "nagaram"));
    }


    public static boolean isAnagram(String s, String t) {
        int[] a = new int[26];
        for (char si : s.toCharArray()) {
            a[si - 'a']++;
        }
        for (char ti : t.toCharArray()) {
            --a[ti - 'a'];
        }
        for (int i = 0; i <= 25; i++) {
            if (a[i] != 0) return false;
        }
        return true;
    }

}