public class L_191 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(-1));
        System.out.println(hammingWeight(-2));
        System.out.println(hammingWeight(-3));
        System.out.println(hammingWeight(-4));
        System.out.println(hammingWeight(-2147483648));
    }

    public static int hammingWeight(int n) {
        long x = n & 0x00000000ffffffffL;
        int res = 0;
        while (x > 0) {
            res += x % 2;
            x = x / 2;
        }
        return res;
    }
}