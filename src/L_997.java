public class L_997 {
    private static byte[] bytes;

    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{{1, 2}}));
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    }


    public static int findJudge(int n, int[][] trust) {
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            a[trust[i][0]]++;
            b[trust[i][1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (a[i] == 0 && b[i] == n - 1) return i;
        }
        return -1;
    }
}
