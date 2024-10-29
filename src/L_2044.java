import java.util.Arrays;

public class L_2044 {
    public static void main(String[] args) {
        System.out.println(countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(countMaxOrSubsets(new int[]{3, 2, 1, 5}));
        System.out.println(countMaxOrSubsets(new int[]{4, 4, 5, 5, 6, 6, 7, 8}));
    }


    public static int countMaxOrSubsets(int[] nums) {
        Arrays.sort(nums);
        int y = nums[0];
        for (int i = 1; i < nums.length; i++) {
            y = (y | nums[i]);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += hisobla(i + 1, nums[i], y, nums);
        }
        return res;
    }

    private static int hisobla(int index, int current, int y, int[] a) {
        if (current == y) return (int) Math.pow(2, a.length - index);
        int sum = 0;
        for (int i = index; i < a.length; i++) {
            sum += hisobla(i + 1, current | a[i], y, a);
        }
        return sum;
    }
}
