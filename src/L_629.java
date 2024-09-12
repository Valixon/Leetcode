public class L_629 {

    public static void main(String[] args) {
        System.out.println(kInversePairs(3, 0));
        System.out.println(kInversePairs(3, 1));
        System.out.println(kInversePairs(300, 100));//86577949
        System.out.println(kInversePairs(1000, 1000));//663677020
    }

    public static int kInversePairs(int n, int k) {
        long[][] qiymat = new long[n + 1][k + 2];
        for (int i = 0; i <= n; i++) {
            qiymat[i][0] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = Math.max(0, j - i + 1); l <= j; l++) {
                    qiymat[i][j] += qiymat[i - 1][l];
                    qiymat[i][j] %= 1000000007;
                }
            }
        }
        return (int) qiymat[n][k];
    }
}
