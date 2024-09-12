public class L_1913 {
    public static void main(String[] args) {
        System.out.println(maxProductDifference(new int[]{5, 6, 2, 7, 4}));
    }


    public static int maxProductDifference(int[] nums) {
        int[] a = new int[10001];
        int x = 0, y = 0, z = 10000, w = 0;
        for (int num : nums) {
            a[num]++;
            if (x < num) {
                x = num;
            }
            if (z > num) z = num;
        }
        a[x]--;
        a[z]--;
        for (int i = x; i >= 0; i--) {
            if (a[i] > 0) {
                a[i]--;
                y = i;
                break;
            }
        }
        for (int i = z; i <= y; i++) {
            if (a[i] > 0) {
                a[i]--;
                w = i;
                break;
            }
        }
        return x * y - z * w;
    }
}