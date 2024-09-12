import java.util.Scanner;

public class L_880 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(decodeAtIndex(sc.next(), sc.nextInt()));
    }

    public static String decodeAtIndex(String s, int k) {
        long kk = (long) k;
        char[] a = s.toCharArray();
        long uzunligi;
        while (true) {
            uzunligi = 0;
            for (char c : a) {
                if (c - 50 >= 0 && c - 50 <= 7) {
                    if (uzunligi * (c - 48) >= kk) {
                        kk = kk % uzunligi;
                        if (kk == 0) kk = uzunligi;
                        break;
                    }
                    uzunligi *= (c - 48);
                } else {
                    uzunligi++;
                    if (uzunligi == kk) {
                        return "" + c;
                    }
                }
            }
        }
    }
}
