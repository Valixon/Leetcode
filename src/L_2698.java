public class L_2698 {

    public static void main(String[] args) {
        System.out.println(punishmentNumber(10));
        System.out.println(punishmentNumber(37));
    }


    public static int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (addDigits(i) == addDigits(i * i)) {
                sum += i * i;
                System.out.println(i + " " + i * i);
            }
        }
        return sum;
    }

    private static int addDigits(int n) {
        return ((n - 1) % 9) + 1;
    }
}
