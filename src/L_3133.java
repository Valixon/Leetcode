public class L_3133 {
    public static void main(String[] args) {
        System.out.println(minEnd(3, 4));
        System.out.println(minEnd(2, 7));
        System.out.println(minEnd(3, 7));
        System.out.println(minEnd(4, 7));
    }

    public static long minEnd(int n, int x) {
        if (n == 1) return x;
        String s = Integer.toBinaryString(x);
        int o = 0;
        for (char i : s.toCharArray()) {
            if (i == '0') o++;
        }
        int p = 0;
        int daraja = 1;
        while (p < o) {
            daraja *= 2;
            p++;
        }
        while (daraja < n) {
            daraja*=2;
        }
        
        System.out.println(daraja);
        return 1;
    }
}