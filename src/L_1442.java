public class L_1442 {

    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(countTriplets(new int[]{1, 1, 1, 1, 1}));
    }


    public static int countTriplets(int[] arr) {
        int n = arr.length;
        int res = 0;
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                a[i][j] = a[i][j - 1] ^ arr[j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if (a[i][j - 1] == a[j][k]) res++;
                }
            }
        }
        return res;
    }
}