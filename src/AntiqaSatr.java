import java.util.Scanner;

public class AntiqaSatr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long x = n - 1;
        long y = x * 8 + 1;
        long u = (long) Math.sqrt(y);
        if (u * u == y) {
            if (y % 2 == 1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else {
            System.out.println(0);
        }
    }
}