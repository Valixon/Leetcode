
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class ACMP71 {
    private static int n;
    private static int S;
    private static int min;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        ZonedDateTime s = ZonedDateTime.now();
        System.out.println(s.format(DateTimeFormatter.ofPattern("yyyy.MM.dd'T'HH:mm:ss.SSSXXX")));
//        n = sc.nextInt();
//        int[] a = new int[n];
//        S = 0;
//        for (int i = 0; i < a.length; i++) {
//            a[i] = sc.nextInt();
//            S = S + a[i];
//        }
//
//        Arrays.sort(a);
//        int s = a[n - 1];
//        if (s - (S - s) >= 0) {
//            min = s - (S - s);
//        } else {
//            min = S;
//        }
//
//        general(a, 0, s);
//
//        S = (S - min) / 2;
//        pw.print(min);
//        pw.close();
    }

    private static void general(int[] a, int j, int s) {
        for (int i = j; i <= n - 1; i++) {

            if ((min > Math.abs(S - (2 * s)))) {
                min = Math.abs(S - (2 * s));
                if (S - (2 * s) <= 0) {
                    i = n - 1;
                }
            }
            s = s + a[i];

            general(a, i + 1, s);

            s = s - a[i];

        }
    }
}