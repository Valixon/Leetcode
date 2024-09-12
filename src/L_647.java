public class L_647 {
    private static byte[] bytes;

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }


    public static int countSubstrings(String s) {
        int n = s.length();
        bytes = new byte[n];
        s.getBytes(0, n, bytes, 0);
        int res = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (bytes[i] == bytes[j]) continue;
                if (palindrom(i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean palindrom(int boshi, int oxiri) {
        int urta = (boshi + oxiri + 1) / 2;
        for (int i = boshi; i <= urta; i++) {
            if (bytes[i] != bytes[oxiri - (i - boshi)]) return false;
        }
        return true;
    }
}
