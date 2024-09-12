import java.util.Arrays;

public class L_2433 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findArray(new int[]{5, 2, 0, 3, 1})));
    }

    public static int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            arr[i] = pref[i - 1] ^ pref[i];
        }
        return arr;
    }
}
