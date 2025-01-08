import java.util.Scanner;


public class ROBO_D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int n = sc.nextInt();
        long sum = a;
        for (int i = 0; i < n; i++) {
            sum += (a - sc.nextLong());
        }
        System.out.println(sum);
    }
}
