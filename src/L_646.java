import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class L_646 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        System.out.println(findLongestChain(a));
    }

    public static int findLongestChain(int[][] pairs) {
        int[] qadamlar = new int[pairs.length];
        qadamlar[0] = 0;
        int max = 0;
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < pairs.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    qadamlar[i] = Math.max(qadamlar[i], qadamlar[j] + 1);
                    if (max + 1 == qadamlar[i]) {
                        System.out.println("da");
                        break;
                    }
                }
            }
            max = Math.max(max, qadamlar[i]);
        }
        System.out.println(Arrays.deepToString(pairs));
        System.out.println(Arrays.toString(qadamlar));
        return max + 1;
    }
}
