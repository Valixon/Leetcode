public class L_1780 {

    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(21));
    }

    public static boolean checkPowersOfThree(int n) {
        if (n == 2) return false;
        if (n == 1 || n == 0) return true;
        int x = 1;
        while (x * 3 <= n) {
            x *= 3;
        }
        n = n - x;
        if (n >= x) return false;
        return checkPowersOfThree(n);
    }
}