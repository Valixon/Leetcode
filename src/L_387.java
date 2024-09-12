public class L_387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));
    }


    public static int firstUniqChar(String s) {
        int[] soni = new int['z' + 1];
        int[] joyi = new int['z' + 1];
        byte[] bytes = new byte[s.length()];
        s.getBytes(0, s.length(), bytes, 0);
        for (int i = 0; i < s.length(); i++) {
            soni[bytes[i]]++;
            joyi[bytes[i]] = i;
        }
        int res = 1000000;
        for (char i = 'a'; i <= 'z'; i++) {
            if (soni[i] == 1) {
                res = Math.min(res, joyi[i]);
            }
        }
        return res == 1000000 ? -1 : res;
    }
}
