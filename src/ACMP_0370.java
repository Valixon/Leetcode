import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;


public class ACMP_0370 {
    public static void main(String[] args) throws FileNotFoundException {
        Locale.setDefault(Locale.US);
        Scanner st = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        int t = 0;
        while (t < 1) {
            t++;
            Random random = new Random();
            int n = random.nextInt(1000 + 1 - 3) + 3;
            int[][] points = new int[n][2];
            points[0][0] = random.nextInt(2000 + 1 - (-2000)) - 2000;
            points[0][1] = random.nextInt(2000 + 1 - (-2000)) - 2000;
            points[1][0] = random.nextInt(2000 + 1 - (-2000)) - 2000;
            points[1][1] = random.nextInt(2000 + 1 - (-2000)) - 2000;
            for (int i = 2; i < n; i++) {
                points[i][0] = random.nextInt(2000 + 1 - (-2000)) - 2000;
                points[i][1] = random.nextInt(2000 + 1 - (-2000)) - 2000;
                if (areaOfPolygon(new int[][]{{points[0][0], points[0][1]}, {points[i - 1][0], points[i - 1][1]}, {points[i][0], points[i][1]}}) == 0) {
                    i--;
                }
            }
            pw.print("Input: points = [");
            for (int i = 0; i < n; i++) {
                pw.print("["+points[i][0]+","+points[i][1]+",");

            }
            pw.println();
            pw.print("Output: ");
            pw.printf("%.2f", Math.abs(areaOfPolygon(points)));
            pw.println();
        }
        pw.close();
    }

    public static double areaOfPolygon(int[][] points) {
        double s = 0;
        for (int i = 1; i < points.length - 1; i++) {
            s = s + ((points[i][0] - points[0][0]) * (points[i + 1][1] - points[0][1]) - (points[i + 1][0] - points[0][0]) * (points[i][1] - points[0][1]));
        }
        return Math.abs(s / 2);
    }
}
