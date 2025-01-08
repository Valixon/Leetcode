import java.util.Scanner;


public class ROBO_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        if (k == 1) {
            System.out.println(1);
            return;
        }
        long a = k / (2 * (n - 1));
        long b = k % (2 * (n - 1));
        if (a > 0) b += 2L;
        long op = b / 2 * 3;
        if (b % 2 == 0) {
            System.out.println(op - 1 + " " + op);
        } else {
            System.out.println(op + 1);
        }
    }
}
