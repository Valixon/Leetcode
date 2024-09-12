public class L_945 {

    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{1, 2, 2}));
        System.out.println(minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }


    public static int minIncrementForUnique(int[] nums) {
        int res = 0;
        int[] a = new int[200001];
        int max = 0;
        for (int i : nums) {
            a[i]++;
            max = Math.max(max, i);
        }
        for (int i = 0; i < nums.length + max; i++) {
            if (a[i] > 1) {
                int p = a[i] - 1;
                res += p;
                a[i + 1] += p;
            }
        }
        if (a[100000] > 1) {
            int n = a[100000] - 1;
            res += ((n + 1) * n) / 2;
        }
        return res;
    }
}