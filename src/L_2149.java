import java.util.Arrays;

public class L_2149 {
    private static byte[] bytes;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
        System.out.println(Arrays.toString(rearrangeArray(new int[]{-1, 1})));
    }


    public static int[] rearrangeArray(int[] nums) {
        int indexMusbat = -2;
        int indexManfiy = -1;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num > 0) {
                res[indexMusbat += 2] = num;
            } else {
                res[indexManfiy += 2] = num;
            }
        }
        return res;
    }
}
