import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class ACMP_0917 {
    public static void main(String[] args) {
        for (double i = 0.00000001; i <= 2; i = i + 0.000000001) {
            double x = Math.sqrt((4.5 * 4.5) + (i * i));
            double y = Math.sqrt((1.5 * 1.5) + ((4 - i) * (4 - i)));
            if (Math.abs(x - y) <= 0.2) {
                System.out.println("yechim" + i);
                return;
            }
        }
        System.out.println("yo'q");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }
        Arrays.sort(a);
        double markazgacha = a[n - 1] / 2;
        double qadam = 0.00;
//        while (markazgacha + qadam < n * a[n - 1]) {
//            if (hisobla(markazgacha + qadam, a, 0.1)) {
//                break;
//            }
//            qadam += 0.1;
//        }
        while (markazgacha + qadam < markazgacha + 0.2) {
            if (hisobla(markazgacha + qadam, a, 0.01)) {
                break;
            }
            qadam += 0.01;
        }
        qadam -= 0.01;
        while (markazgacha + qadam < markazgacha + 10) {
            if (hisobla(markazgacha + qadam, a, 0.009)) {
                break;
            }
            qadam += 0.001;
        }
//        qadam -= 0.001;
//        while (markazgacha + qadam < markazgacha + 100) {
//            if (hisobla(markazgacha + qadam, a, 0.0009)) {
//                break;
//            }
//            qadam += 0.0001;
//        }
        markazgacha = markazgacha + qadam;
        double s = 0;
        for (double katet : a) {
            double p = (markazgacha + markazgacha + katet) / 2;
            s = s + (Math.sqrt(p * (p - katet) * (p - markazgacha) * (p - markazgacha)));
        }
//        System.out.println(s);
        pw.printf("%.2f", s);
        pw.close();
    }

    private static boolean hisobla(double markazgacha, double[] a, double def) {
        double gradus = 0;
        for (double katet : a) {
            gradus = gradus + (Math.asin(katet / (2 * markazgacha)));
        }
        System.out.println(markazgacha + " " + gradus + " " + (Math.PI - gradus));
        if (gradus <= def || (gradus <= Math.PI && Math.PI - gradus <= def)) {
            return true;
        }
        return false;
    }
}
