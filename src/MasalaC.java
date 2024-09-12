import java.util.Scanner;

public class MasalaC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long q = sc.nextLong();
        long b = sc.nextLong();
        long k = sc.nextLong();
        if (k >= b + q) {
            System.out.println(0);
            return;
        }
        long mumkin = 0;
        long qoladi = 0;
        if (q > b * 2) {
            mumkin = b;
            qoladi = q - (mumkin * 2);
        } else {
            mumkin = q / 2;
            qoladi = b - mumkin;
            qoladi += q % 2;
        }
        if (qoladi >= k) {
            System.out.println(mumkin);
            return;
        }
        k = k - qoladi;
        mumkin -= (k + 2) / 3;
        System.out.println(mumkin);
    }
}
