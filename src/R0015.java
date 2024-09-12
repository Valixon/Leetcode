import java.util.Scanner;

public class R0015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long MOD = 1000000007;

        long n = sc.nextLong() % MOD;
        long k = sc.nextLong() % MOD;
        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            long x = power(k, n, MOD);
            System.out.println((x - 1) / (k - 1));
        }
    }

    static long power(long x,
                      long y, long p)
    {
        long res = 1; // Initialize result

        // Update x if it is more
        // than or equal to p
        x = x % p;

        while (y > 0)
        {
            // If y is odd, multiply
            // x with the result
            if ((y & 1) > 0)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }
}
