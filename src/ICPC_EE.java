import java.util.Random;
import java.util.Scanner;

public class ICPC_EE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            if (isPrime(sc.nextLong(), 10)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static boolean isPrime(long n, int iterations) {
        if (n < 2) return false; // 2 dan kichik sonlar tub emas
        if (n == 2 || n == 3) return true; // 2 va 3 tub sonlar
        if (n % 2 == 0) return false; // Juft sonlar murakkab

        // n - 1 ni 2^s * d shaklida yozish
        long d = n - 1;
        int s = 0;
        while (d % 2 == 0) {
            d /= 2;
            s++;
        }

        // Tasodifiy sinovlar o'tkazish
        Random random = new Random();
        for (int i = 0; i < iterations; i++) {
            long a = 2 + (Math.abs(random.nextLong()) % (n - 4)); // 2 <= a <= n-2
            if (!millerTest(a, d, s, n)) {
                return false; // Agar bitta testda o'tmasa, murakkab
            }
        }

        return true; // Agar barcha sinovlardan o'tsa, tub son bo'lishi mumkin
    }

    // Miller testi
    private static boolean millerTest(long a, long d, int s, long n) {
        long x = modExp(a, d, n); // a^d % n ni hisoblash

        if (x == 1 || x == n - 1) return true; // Birinchi tekshiruv

        for (int i = 0; i < s - 1; i++) {
            x = modExp(x, 2, n); // x = x^2 % n
            if (x == n - 1) return true; // Ikkinchi tekshiruv
        }

        return false; // Tub emas
    }

    // Modular eksponenta hisoblash: (base^exp) % mod
    private static long modExp(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;

        while (exp > 0) {
            if ((exp & 1) == 1) { // Agar exp toq bo‘lsa
                result = (result * base) % mod;
            }
            exp >>= 1; // exp = exp / 2
            base = (base * base) % mod; // base = base^2 % mod
        }

        return result;
    }
}