import java.util.Scanner;

public class L_649 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int a[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
        System.out.println(predictPartyVictory(sc.next()));
    }

    public static String predictPartyVictory(String senate) {
        int a = 0;
        int b = 0;
        int x = senate.length();
        if (senate.charAt(0) == 'D') {
            for (int i = 0; i < x / 4; i++) {
                senate = "D" + senate;
            }
        } else {
            for (int i = 0; i < x / 4; i++) {
                senate = "R" + senate;
            }
        }
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                a++;
            } else {
                b++;
            }
        }
        if (b > a) {
            return "Dire";
        }
        return "Radiant";
    }
}
/*

6
29 51 87 87 72 12

9
1 1 1 1 1 1 1 1 7 1

6
4 1 1 1 1 2 1

35

1 0 4 0 4 1 4 3 1 1 1 2 1 4 0 3 0 3 0 3 0 5 3 0 0 1 2 1 2 4 3 0 1 0 5 2

7
3 3 3 3 3 1 3
 */

