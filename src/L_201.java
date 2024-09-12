public class L_201 {
    private static byte[] bytes;

    public static void main(String[] args) {
        System.out.println(18 & 20);
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(rangeBitwiseAnd(0, 0));
        System.out.println(rangeBitwiseAnd(1, 2147483647));
        System.out.println(rangeBitwiseAnd(600000000, 2147483645));
    }


    public static int rangeBitwiseAnd(int left, int right) {
        if (left == right) return left;
        int y = 1;
        for (int i = 1; i <= 31; i++) {
            y = y * 2;
            if (left < y && right > y) return 0;
        }
        int x = left & right;
        for (int i = left + 1; i < Math.min(right, left + 1024 * 1024); i++) {
            x = x & i;
        }
        return x;
    }
}
