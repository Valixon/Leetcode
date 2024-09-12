import java.util.Arrays;

public class L_1503 {

    public static void main(String[] args) {
        System.out.println(getLastMoment(4, new int[]{4, 3}, new int[]{0, 1}));
        System.out.println(getLastMoment(7, new int[]{}, new int[]{0, 1, 2, 3, 4, 5, 6, 7}));
        System.out.println(getLastMoment(7, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, new int[]{}));
    }

    public static int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        for (int j : left) {
            res = Math.max(res, j);
        }
        for (int j : right) {
            res = Math.max(res, n - j);
        }
        return res;
    }
}
