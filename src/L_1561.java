public class L_1561 {
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
        System.out.println(maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
    }

    public static int maxCoins(int[] piles) {
        int[] a = new int[10001];
        int max = 1;
        int min = 1000;
        for (int pile : piles) {
            if (max < pile) max = pile;
            if (min > pile) min = pile;
            a[pile]++;
        }
        int n = piles.length / 3;
        int u = min;
        while (n >= a[u]) {
            n = n - a[u];
            u++;
        }
        if (n != 0) a[u] -= n;
        int sum = 0;
        int qoldiq = 0;
        int y = 0;
        for (int i = max; i >= u; i--) {
            y = a[i] + qoldiq;
            sum += (i * (y / 2));
            qoldiq = y % 2;
        }
        return sum;
    }
}