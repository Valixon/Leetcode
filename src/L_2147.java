public class L_2147 {
    public static void main(String[] args) {
        System.out.println(numberOfWays("SSPPSPS"));
        System.out.println(numberOfWays("PPSPSP"));
        System.out.println(numberOfWays("S"));
        System.out.println(numberOfWays("SSS"));
        System.out.println(numberOfWays("P"));
    }

    public static int numberOfWays(String corridor) {
        long p = 1;
        byte countS = 0;
        int countP = 1;
        char[] a = corridor.toCharArray();
        for (char ch : a) {
            if (ch == 'P') {
                if (countS == 2) {
                    countP++;
                }
            } else {
                countS++;
                if (countS == 3) {
                    p = (p * countP) % 1000000007;
                    countS = 1;
                    countP = 1;
                }
            }
        }
        if (countS < 2) return 0;
        return (int) (p % 1000000007);
    }
}