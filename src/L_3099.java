public class L_3099 {
    public static void main(String[] args) {
        System.out.println(sumOfTheDigitsOfHarshadNumber(100));
        System.out.println(sumOfTheDigitsOfHarshadNumber(23));
        System.out.println(sumOfTheDigitsOfHarshadNumber(18));
    }


    public static int sumOfTheDigitsOfHarshadNumber(int x) {
        int sumNumber = 0;
        int temp = x;
        while (temp > 0) {
            sumNumber += temp % 10;
            temp /= 10;
        }
        if (x % sumNumber == 0)
            return sumNumber;
        return -1;
    }
}
