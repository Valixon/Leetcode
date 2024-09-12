import java.util.Arrays;

public class L_1637 {
    public static void main(String[] args) {
        System.out.println(maxWidthOfVerticalArea(new int[][]{{3, 1}, {9, 0}, {1, 1}, {1, 5}, {5, 0}, {7, 8}}));
    }


    public static int maxWidthOfVerticalArea(int[][] points) {
        int[] a = new int[points.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = points[i][0];
        }
        Arrays.sort(a);
        int max = a[1] - a[0];
        for (int i = a.length - 1; i >= 2; i--) {
            int i1 = a[i] - a[i - 1];
            if (max < i1) {
                max = i1;
            }
        }
        return max;
    }
}