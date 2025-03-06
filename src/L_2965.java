import java.util.Arrays;

public class L_2965 {
    private static byte[] bytes;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}})));
    }


    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        short[] a = new short[2501];
        int n = 0;
        for (int[] ints : grid) {
            n += grid.length;
            for (int anInt : ints) {
                a[anInt]++;
            }
        }
        int x = 0, y = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] == 2) x = i;
            if (a[i] == 0) y = i;
        }
        return new int[]{x, y};
    }
}
