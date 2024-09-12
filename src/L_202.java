public class L_202 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
        System.out.println(isHappy(4));
    }

    public static boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            n = hisobla(n);
        }
        return n == 1;
    }

    public static int hisobla(int n) {
        int summa = 0;
        while (n > 9) {
            int x = n % 10;
            summa += ((x) * (x));
            n = n / 10;
        }
        summa += ((n) * (n));
        return summa;
    }
}