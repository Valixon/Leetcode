import java.util.Arrays;

public class L_075 {

    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }


    public static void sortColors(int[] nums) {
        int[] a = new int[3];
        for (int i : nums) {
            a[i]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (a[i] > 0) {
                a[i]--;
                nums[index++] = i;
            }
        }
    }
}