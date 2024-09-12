public class L_3168 {

    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(minimumChairs("EEEEEEE"));
    }


    public static int minimumChairs(String s) {
        int res = 0, max = 0;
        for (char i : s.toCharArray()) {
            if (i == 'E') {
                res++;
            } else {
                max = Math.max(res, max);
                res--;
            }
        }
        return max;
    }
}