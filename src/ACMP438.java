import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ACMP438 {
    private static int n;
    private static int tor;
    private static float w;
    private static float r;
    private static float t;
    private static float cre;
    private static float[][] d;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        Locale.setDefault(Locale.US);
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        n = sc.nextInt();
        long[] a = new long[n];
        long[] aa = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i - 1] = sc.nextLong();
            aa[i] = a[i - 1];
        }
        int m = sc.nextInt();
        long[] b = new long[m];
        long[] bb = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            b[i - 1] = sc.nextLong();
            bb[i] = b[i - 1];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        d = new float[n + 1][n + 2];
        float dd[][] = new float[n + 1][n + 2];
        float ddd[][] = new float[n + 1][n + 2];
        for (int j = 1; j <= n; j++) {
            if (m - j + 1 > 0) {
                d[1][j] = b[m - j];
            } else {
                d[1][j] = 0;
            }
            d[j][n + 1] = a[n - j];
        }
        printQil(d);
        for (int i = 2; i <= n; i++) {
            d[i][n] = d[i - 1][1];
            for (int j = 1; j < n; j++) {
                d[i][j] = d[i - 1][j + 1];
            }
        }
        printQil(d);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n + 1; j++) {
                dd[i][j] = d[i][j];
                ddd[i][j] = d[i][j];
            }
        }
        long so = 0, po = 0;
        for (int i = 1; i <= n; i++) {
            so = so + (long) d[1][i];
            po = po + (long) d[i][n + 1];
        }


        int son = 0;
        for (int i = 1; i <= n; i++) {
            if (d[1][1] == d[i][1]) {
                son++;
            }
        }
        if (son == n) {
            tor = 1;
            for (int i = 1; i <= n; i++) {
                d[i][n + 1] = d[i][n + 1] / d[1][1];
            }
            pw.printf("%.3f", d[1][n + 1]);
            pw.println();
        } else {
            double ro = (double) po / so;

            Analetik(1, 1);
            for (int i = 1; i <= n; i++) {
                //System.out.prlongln(d[i][n+1]);
                if (d[i][n + 1] < 0) {
                    tor = 1;
                    ro = dd[1][n + 1] / dd[1][1];
                }

            }
            pw.printf("%.3f", ro);
            pw.println();
        }
        double s = 0, p = 0, pq = 0;
        long qoch = 0;
        if (tor == 1) {
            qoch = 1;
        } else {
            qoch = n;
        }
        ;
        for (int i = 1; i <= qoch; i++) {
            for (int i2 = 1; i2 <= n; i2++) {

                a[i2 - 1] = aa[i2];
            }
            for (int i2 = 1; i2 <= m; i2++) {

                b[i2 - 1] = bb[i2];
            }
            double wer = s;
            s = s + d[i - 1][n + 1];
            if ((wer != s) || (s == 0)) {
                for (int j = 1; j <= n; j++) {
                    p = 0;
                    pq = 0;
                    for (int j2 = 1; j2 <= n; j2++) {
                        if (a[j2 - 1] == ddd[j][n + 1]) {
                            p = j2;
                            a[j2 - 1] = -2;
                            j2 = n;
                        }
                    }
                    for (int j2 = 0; j2 < m; j2++) {
                        if (b[j2] == ddd[j][i]) {
                            pq = j2 + 1;
                            b[j2] = -2;
                            j2 = m - 1;
                        }
                    }
                    if (pq != 0) {

                        pw.printf("%.10f", s);
                        pw.print(" " + (int) p + " " + (int) pq);
                        pw.println();


                    }
                }
            }


        }
        pw.close();
    }

    private static void printQil(float[][] d) {
//        System.out.println();
//        for (int i = 1; i < d.length; i++) {
//            for (int j = 1; j < d.length; j++) {
//                System.out.print(d[i][j] + " ");
//            }
//            System.out.println();
//        }
    }


    private static float round(float d, int i) {
        float f = d * 1000000000;
        f = (long) f;
        f = (float) f / 1000000000;
        return f;
    }


    private static void Analetik(int x, int y) {
        w = d[x][y];
        if (w == 0) {
            qoshish(x, y);
        } else {
            for (int i = 1; i <= n + 1; i++) {
                d[x][i] = (d[x][i] / w);

            }

            r = 0;
            for (int i = 1; i <= x - 1; i++) {
                r = d[i][y];
                for (int j = 1; j <= n + 1; j++) {

                    d[i][j] = d[i][j] - d[x][j] * r;
                }
            }
            t = 0;
            for (int i = x + 1; i <= n; i++) {
                t = d[i][y];
                for (int j = 1; j <= n + 1; j++) {

                    d[i][j] = d[i][j] - d[x][j] * t;
                    ;
                }
            }

            if (x + 1 < n + 1 && y + 1 < n + 1) {
                Analetik(x + 1, y + 1);
            }
        }

    }

    private static void qoshish(int x, int y) {
        x = x + 1;
        if (x == n + 1) {
            x = n;
        }
        if (d[x][y] != 0) {
            qoshish3(x, y);
        } else {
            qoshish(x, y);
        }

    }


    private static void qoshish3(int x, int y) {
        for (int i = 1; i <= n + 1; i++) {
            cre = d[y][i];
            d[y][i] = d[x][i];
            d[x][i] = cre;
        }
        Analetik(y, y);
    }
}