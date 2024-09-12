import java.util.Arrays;

public class L_935 {
    public static void main(String[] args) {
        System.out.println(knightDialer(1));
        System.out.println(knightDialer(2));
        System.out.println(knightDialer(3));
        System.out.println(knightDialer(4));
        System.out.println(knightDialer(5));
        System.out.println(knightDialer(6));
        System.out.println(knightDialer(7));
        System.out.println(knightDialer(5000));
    }

    public static int knightDialer(int n) {
        if (n < 3) return n * 10;
        long[] a = new long[10];
        Arrays.fill(a, 1);
        long[] b = new long[10];
        Arrays.fill(b, 1);
        b[5] = 0;
        a[5] = 0;
        for (int i = 1; i < n; i++) {
            a[1] = (b[6] + b[8]) % 1000000007;
            a[2] = (b[7] + b[9]) % 1000000007;
            a[3] = (b[4] + b[8]) % 1000000007;
            a[4] = (b[3] + b[9] + b[0]) % 1000000007;
            a[6] = (b[1] + b[7] + b[0]) % 1000000007;
            a[7] = (b[2] + b[6]) % 1000000007;
            a[8] = (b[1] + b[3]) % 1000000007;
            a[9] = (b[2] + b[4]) % 1000000007;
            a[0] = (b[4] + b[6]) % 1000000007;
            b = new long[10];
            for (int j = 0; j <= 9; j++) {
                b[j] = a[j];
            }
        }
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += a[i];
        }
        return (int) (sum % 1000000007);
    }


}