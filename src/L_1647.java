import java.util.Arrays;
import java.util.Scanner;

public class L_1647 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(minDeletions(sc.next()));
    }

    public static int minDeletions(String s) {
        int[] soni = new int[26];
        for (int i = 0; i < s.length(); i++) {
            soni[(int) s.charAt(i) - 97]++;
        }
        Arrays.sort(soni);
        int summa = 0;
        while (true) {
            boolean ishladi = false;
            for (int i = 1; i <= 25; i++) {
                if (soni[i] == 0) continue;
                if (soni[i - 1] == soni[i]) {
                    soni[i - 1]--;
                    summa++;
                    ishladi = true;
                    i=i-1;
                }
            }
            if (!ishladi) {
                break;
            }
        }
        return summa;
    }
}
/*

5
3 4 1 1 0 0

9
1 1 1 1 1 1 1 1 7 1

6
4 1 1 1 1 2 1

35

1 0 4 0 4 1 4 3 1 1 1 2 1 4 0 3 0 3 0 3 0 5 3 0 0 1 2 1 2 4 3 0 1 0 5 2

7
3 3 3 3 3 1 3
 */

