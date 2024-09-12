import java.util.Scanner;

public class ToshUloqtirish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        String message = "Right";
        if (x < 0) {
            message = "Left";
            x = x * -1;
        }
        long l1 = sc.nextLong();
        long r1 = sc.nextLong();
        long l2 = sc.nextLong();
        long r2 = sc.nextLong();
        long x2 = (long) Math.sqrt(x);
        if (x == 0 && (l1 == 0 || l2 == 0)) {
            System.out.println(message);
            System.out.println(l1 + " " + l2);
            return;
        }
        for (long i = 1; i <= x2; i++) {
            if (x % i == 0) {
                long b = x / i;
                if ((oraliqdami(l1, r1, i) && oraliqdami(l2, r2, b))) {
                    System.out.println(message);
                    System.out.println(i + " " + b);
                    return;
                } else if ((oraliqdami(l1, r1, b) && oraliqdami(l2, r2, i))) {
                    System.out.println(message);
                    System.out.println(b + " " + i);
                    return;
                }
            }
        }
        System.out.println("Impossible");
    }

    private static boolean oraliqdami(long l, long r, long a) {
        return l <= a && a <= r;
    }
}