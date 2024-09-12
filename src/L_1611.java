public class L_1611 {
    public static int daraja;

    public static void main(String[] args) {
        System.out.println(minimumOneBitOperations(2));
        System.out.println(minimumOneBitOperations(3));
        System.out.println(minimumOneBitOperations(6));
        System.out.println(minimumOneBitOperations(7));
        System.out.println(minimumOneBitOperations(8776));
    }

    public static int minimumOneBitOperations(int n) {
        if (n < 2) return n;
        daraja = 1;
        while (daraja * 2 <= n) {
            daraja *= 2;
        }
        return (daraja * 2 - 1) - minimumOneBitOperations(n - daraja);
    }
}