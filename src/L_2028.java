import java.util.Arrays;

public class L_2028 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(missingRolls(new int[]{3, 2, 4, 3}, 4, 2)));
        System.out.println(Arrays.toString(missingRolls(new int[]{1, 5, 6}, 3, 4)));
        System.out.println(Arrays.toString(missingRolls(new int[]{1, 2, 3, 4}, 6, 4)));
    }


    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        int m = rolls.length;
        for (int roll : rolls) {
            sum += roll;
        }
        double x = (double) ((mean * (n + m)) - sum) / n;
        if (x > 6) {
            return new int[]{};
        }
        int res[] = new int[n];
        int p = ((mean * (n + m)) - sum) / n;
        int q = ((mean * (n + m)) - sum) % n;
        for (int i = 0; i < q; i++) {
            res[i] = p + 1;
        }
        for (int i = q; i < n; i++) {
            res[i] = p;
        }
        return res;
    }
}