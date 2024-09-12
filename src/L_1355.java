import java.util.Arrays;

public class L_1355 {

    public static void main(String[] args) {
        System.out.println(minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
        System.out.println(minDifficulty(new int[]{9, 9, 9}, 4));
        System.out.println(minDifficulty(new int[]{1, 1, 1}, 3));
    }


    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        if (n == d) {
            return Arrays.stream(jobDifficulty).sum();
        }
        int[][] dp = new int[n][n];

        return cutRod(jobDifficulty, jobDifficulty.length - 1, d);
    }

    static int cutRod(int price[], int index, int n) {
        // base case
        if (index == 0) {
            return n * price[0];
        }
        // At any index we have 2 options either
        // cut the rod of this length or not cut
        // it
        int notCut = cutRod(price, index - 1, n);
        int cut = Integer.MAX_VALUE;
        int rod_length = index + 1;

        if (rod_length <= n)
            cut = price[index]
                    + cutRod(price, index, n - rod_length);

        return Math.min(notCut, cut);
    }
}