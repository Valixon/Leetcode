import java.util.Scanner;

public class MasalaA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(((n / 2) + 1) * (((n + 1) / 2) + 1));
    }
}
