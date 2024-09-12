public class L_343 {
    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(3));
        System.out.println(integerBreak(4));
        System.out.println(integerBreak(9));
        System.out.println(integerBreak(10));
        System.out.println(integerBreak(11));
        System.out.println(integerBreak(58));
    }

    public static int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int uch = n / 3;
        int p = 1;
        if (n % 3 == 1) {
            uch--;
            p = 4;
        }
        if (n % 3 == 2) {
            p = 2;
        }
        for (int i = 1; i <= uch; i++) {
            p *= 3;
        }
        return p;
    }

    public static int power(int x, int y) {
        int res = 1;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x);
            y = y >> 1;
            x = (x * x);
        }
        return res;
    }
}
