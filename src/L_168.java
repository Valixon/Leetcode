import java.util.Scanner;

public class L_168 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println(convertToTitle(sc.nextInt()));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        byte p;
        while (columnNumber > 0) {
            p = (byte) (columnNumber % 26);
            result.insert(0, (char) (p + 64));
            columnNumber = (columnNumber - 1) / 26;
        }
        return result.toString();
    }
}
// 8 3    1 3 -1 -3 5 3 6 7