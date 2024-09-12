import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ACMP_0012 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        double[] x0 = new double[n + 1];
        double[] y0 = new double[n + 1];
        double[] x1 = new double[n + 1];
        double[] y1 = new double[n + 1];
        double[] x2 = new double[n + 1];
        double[] y2 = new double[n + 1];
        double[] x3 = new double[n + 1];
        double[] y3 = new double[n + 1];
        double[] x4 = new double[n + 1];
        double[] y4 = new double[n + 1];
        double[] sq = new double[n + 1];
        double[] tr = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            x0[i] = sc.nextDouble();
            y0[i] = sc.nextDouble();
            x1[i] = sc.nextDouble();
            y1[i] = sc.nextDouble();
            x2[i] = sc.nextDouble();
            y2[i] = sc.nextDouble();
            x3[i] = sc.nextDouble();
            y3[i] = sc.nextDouble();
            x4[i] = sc.nextDouble();
            y4[i] = sc.nextDouble();

            sq[i] = Math.abs(((x2[i] - x1[i]) * (y2[i] - y3[i])) - ((y2[i] - y1[i]) * (x2[i] - x3[i])));
            double s1 = (double) (Math.abs(((x1[i] - x0[i]) * (y2[i] - y0[i])) - (y1[i] - y0[i]) * (x2[i] - x0[i]))) / 2;
            double s2 = (double) (Math.abs(((x2[i] - x0[i]) * (y3[i] - y0[i])) - (y2[i] - y0[i]) * (x3[i] - x0[i]))) / 2;
            double s3 = (double) (Math.abs(((x3[i] - x0[i]) * (y4[i] - y0[i])) - (y3[i] - y0[i]) * (x4[i] - x0[i]))) / 2;
            double s4 = (double) (Math.abs(((x4[i] - x0[i]) * (y1[i] - y0[i])) - (y4[i] - y0[i]) * (x1[i] - x0[i]))) / 2;
            tr[i] = s1 + s2 + s3 + s4;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (sq[i] == tr[i]) {
                sum++;
            }

        }
        pw.print(sum);


        pw.close();
    }

}







