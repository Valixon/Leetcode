import java.util.Scanner;

public class ICPC_G {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int b = sc.nextInt();
        if (x >= b) {
            System.out.println(-1);
            return;
        }
        if (x == 1) {
            System.out.print("1 0 ");
            for (int i = 2; i < b; i++) {
                System.out.print(i + " ");
            }
            return;
        }
        int y = b % x;
        if (y == 0) y = x;
        System.out.print(y + " 0 ");
        int son = b / x;
        if (y % x == 0) son--;
        for (int i = y + 1; i < y + son; i++) {
            System.out.print(i + " ");
        }
        return;

    }
}