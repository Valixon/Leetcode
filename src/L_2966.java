import java.util.Arrays;

public class L_2966 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2)));
    }

    public static int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int x = n / 3;
        Arrays.sort(nums);
        int[][] res = new int[x][3];
        for (int i = 0; i < x; i++) {
            int q = i * 3;
            int a = nums[q];
            int b = nums[q + 1];
            int c = nums[q + 2];
            if (b - a > k || c - a > k || c - b > k) {
                return new int[0][0];
            }
            res[i][0] = a;
            res[i][1] = b;
            res[i][2] = c;

        }

        return res;
    }

}
