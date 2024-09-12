public class L_1404 {

    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(numSteps("1101"));
        System.out.println(numSteps("11011"));
        System.out.println(numSteps("10"));
    }


    public static int numSteps(String s) {
        int sum = 0;
        int yodda = 0;
        for (int i = s.length() - 1; i >= 1; i--) {
            int x = ((s.charAt(i) - '0') + yodda) % 2;
            if (x == 0) {
                sum += 1;
            } else {
                yodda = 1;
                sum += 2;
            }
        }
        if (((s.charAt(0) - '0') + yodda) % 2 == 0) sum++;
        return sum;
    }
}