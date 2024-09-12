import java.util.Arrays;

public class L_2285 {

    public static void main(String[] args) {
        System.out.println(maximumImportance(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}}));
    }


    public static long maximumImportance(int n, int[][] roads) {
        int[] count = new int[n];
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
        }
        Arrays.sort(count);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ((long) count[i]) * (i + 1);
        }
        return sum;
    }
}