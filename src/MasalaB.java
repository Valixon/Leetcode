import java.util.Scanner;

public class MasalaB {

    private static final int MOD = 1000000007;

    // Euclid algoritmi orqali EKUBni topish
    private static long ekub(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // Fibonacci sonlarini modul MOD asosida hisoblash
    private static int fibonacci(long n) {
        int a = 0, b = 1, c;
        if (n == 0) return a;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long i = scanner.nextLong();
        long j = scanner.nextLong();
        scanner.close();

        long n = ekub(i, j); // Fibonacci sonlarining indekslarining EKUBini topish
        int result = fibonacci(n); // EKUB indeksli Fibonacci sonini hisoblash

        System.out.println(result);
    }
}