import java.util.Arrays;

public class L_1921 {
    public static void main(String[] args) {
//        System.out.println(eliminateMaximum(new int[]{1, 3, 4}, new int[]{1, 1, 1}));
//        System.out.println(eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));
        System.out.println(eliminateMaximum(new int[]{3, 5, 7, 4, 5}, new int[]{2, 3, 6, 3, 2}));
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        double[] salom = new double[dist.length];

        for (int i = 0; i < dist.length; i++) {
            salom[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(salom);
        System.out.println(Arrays.toString(salom));
        int count = 0;
        for (int i = 0; i < dist.length; i++) {
            if (salom[i] >= i + 1) {
                count++;
            } else {
                return Math.max(count, 1);
            }
        }
        return count;
    }
}
//[1, 2, 2, 1, 2, 2, 2, 3, 4, 5, 6, 7, 4, 3, 5]
//[1, 2, 2, 1, 2, 2, 2, 3, 4, 5, 6, 7, 4, 3, 5]