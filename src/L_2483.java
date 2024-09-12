import java.util.Scanner;

public class L_2483 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(bestClosingTime(s));
    }

    public static int bestClosingTime(String customers) {
        int n = customers.length();
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                a[i + 1] = a[i] + 1;
            } else {
                a[i + 1] = a[i];
            }
        }
        int min = n;
        int index = 0;
        int ball;
        for (int i = 0; i <= n; i++) {
            ball = (i + a[n] - 2 * a[i]);
            if (min > ball) {
                min = ball;
                index = i;
                if (min == 0) return index;
            }
        }

        return index;
    }
}
