import java.util.Arrays;

public class L_912 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6})));
    }

    public static int[] sortArray(int[] nums) {
        int[] a = new int[100001];
        int index = 0;
        int p = -50000;
        for (int num : nums) {
            a[num + 50000]++;
            int aa = a[num + 50000];
            for (int j = 0; j < aa; j++) {
                nums[index++] = p  + 50000;
            }
            p++;
        }
        return nums;
    }
}