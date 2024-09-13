import java.util.Arrays;

public class L_1310 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}})));
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        int[] left = new int[arr.length];
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = left[i - 1] ^ arr[i];
        }
        for (int i = 0; i < n; i++) {
            answer[i] = left[queries[i][0]] ^ left[queries[i][1]] ^ arr[queries[i][0]];
        }
        return answer;
    }
}