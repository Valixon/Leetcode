import java.util.Scanner;

public class R0910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int result = minFind(n, 0);
        System.out.println(result);
    }

    private static int minFind(long n, int count) {
        int pastDaraja = (int) (Math.log10(n) / Math.log10(2));
        long past = (long) Math.pow(2L, pastDaraja);
        if (past == n) {
            return count + 1;
        }
        long yuqori = past * 2;
        return Math.min(minFind(yuqori - n, count + 1), minFind(n - past, count + 1));
    }
}
