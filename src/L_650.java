public class L_650 {
    public static void main(String[] args) {
        System.out.println(minSteps(3));
        System.out.println(minSteps(1));
        System.out.println(minSteps(365));
    }

    public static int minSteps(int n) {
        int sum = 0;
        int y = 2;
        while (n >= y) {
            while (n % y == 0) {
                sum += y;
                n=n/y;
            }
            y++;
        }
        return sum;
    }
}