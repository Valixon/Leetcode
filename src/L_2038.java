import java.util.Scanner;

public class L_2038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(winnerOfGame(sc.next()));
    }

    public static boolean winnerOfGame(String colors) {
        char[] a = colors.toCharArray();
        int alar = 0;
        int blar = 0;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] == 'A' && a[i - 1] == 'A' && a[i + 1] == 'A') {
                alar++;
            } else if (a[i] == 'B' && a[i - 1] == 'B' && a[i + 1] == 'B') {
                blar++;
            }
        }
        return alar > blar;
    }
}
