import java.util.Scanner;

public class KEP_0006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = (int) Math.sqrt(n);
        int sum = 0;
        for (int i = 1; i < x; i++) {
            sum = sum + (i * ((i + 1) * (i + 1) - i * i));
        }
        sum += x * (n + 1 - x * x);
        System.out.println(sum);
    }
}
