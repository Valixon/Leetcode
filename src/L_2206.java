public class L_2206 {

    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{3, 2, 3, 2, 2, 2}));
        System.out.println(divideArray(new int[]{1, 2, 3, 4}));
    }


    public static boolean divideArray(int[] nums) {
        int[] count = new int[501];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 500; i >= 1; i--) {
            if (count[i] % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}
