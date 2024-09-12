public class L_1653 {
    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab"));
        System.out.println(minimumDeletions("bbaaaaabb"));
    }

    public static int minimumDeletions(String s) {
        byte[] ch = s.getBytes();
        int a = 0;
        int b = 0;
        for (byte i : ch) {
            if (i == 'a') {
                a++;
            } else {
                b++;
            }
        }
        return salomlashish(0, ch, a, b);
    }

    private static int salomlashish(int index, byte[] ch, int a, int b) {
        if (index == ch.length) return 0;
        if (ch[index] == 'a') return salomlashish(index + 1, ch, a - 1, b);
        return Math.min(salomlashish(index + 1, ch, a, b - 1) + 1, a);

    }
}
