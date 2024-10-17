public class L_670 {
    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(20222));
        System.out.println(maximumSwap(9973));
    }


    public static int maximumSwap(int num) {
        int y=num;
        int[] a = new int[("" + num).length()];
        int op = a.length - 1;
        while (num > 0) {
            a[op--] = num % 10;
            num /= 10;
        }
        boolean bir = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                bir = false;
                break;
            }
        }
        if (bir) return y;
        for (int i = 0; i < a.length; i++) {
            int max = a[i];
            int index = i;
            if (i > 0 && a[i] >= a[i - 1]) continue;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] >= max) {
                    max = a[j];
                    index = j;
                }
            }
            if (max > a[i]) {
                int p = a[i];
                a[i] = a[index];
                a[index] = p;
                int res = 0;
                for (int c : a) {
                    res = res * 10 + (c);
                }
                return res;
            }
        }
        return y;
    }
}
