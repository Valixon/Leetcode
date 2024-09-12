import java.util.Arrays;

public class L_786 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 7}, 1)));
    }


    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double a[] = new double[((n * (n - 1)) / 2) + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                a[index++] = (double) arr[i] / arr[j];
            }
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[k] == (double) arr[i] / arr[j]) {
                    return new int[]{arr[i], arr[j]};
                }
            }
        }
        return new int[]{arr[0], arr[1]};
    }
}