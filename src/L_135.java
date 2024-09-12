import java.util.Random;
import java.util.Scanner;

public class L_135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int a[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
        System.out.println(candy(new int[]{1, 3, 4, 5, 2}));
    }

    public static int candy(int[] ratings) {
        if (ratings.length == 1) return 1;
        int summa = ratings.length;
        int n = ratings.length;
        int[] ball = new int[n];
        if (ratings[0] > ratings[1]) {
            ball[0]++;
        }
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                ball[i] = ball[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                ball[i] = Math.max(ball[i + 1] + 1, ball[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            summa += ball[i];
        }
        return summa;
    }
}
/*

6
29 51 87 87 72 12

9
1 1 1 1 1 1 1 1 7 1

6
4 1 1 1 1 2 1

35

1 0 4 0 4 1 4 3 1 1 1 2 1 4 0 3 0 3 0 3 0 5 3 0 0 1 2 1 2 4 3 0 1 0 5 2

7
3 3 3 3 3 1 3
 */

