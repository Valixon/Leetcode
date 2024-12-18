import java.util.Locale;
import java.util.Scanner;


public class Diz_Masala {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double w = sc.nextDouble();
        double h = sc.nextDouble();
        double d = sc.nextDouble();
        int x = (int) (w / d);
        int y = (int) (h / d);
        double sum = (x * y * d * d) / 2;

        double qoldiH = h - (y * d);
        double qoldiW = w - (x * d);

        double qoldiSum = 0;
        if (d * x < w) x++;
        if (d * y < h) y++;
        if (qoldiH <= d / 2) {
            qoldiSum = qoldiH * qoldiH;
        } else {
            qoldiSum = (d * d / 2) - ((d - qoldiH) * (d - qoldiH));
        }
        sum = sum + (qoldiSum * (x));
        double qoldiSum2 = 0;
        if (qoldiW <= d / 2) {
            qoldiSum2 = qoldiW * qoldiW;
        } else {
            qoldiSum2 = (d * d / 2) - ((d - qoldiW) * (d - qoldiW));
        }
        sum = sum + (qoldiSum2 * (y));
        sum -= Math.max(qoldiSum, qoldiSum2);
        System.out.printf("%.4f", sum);
    }
}
