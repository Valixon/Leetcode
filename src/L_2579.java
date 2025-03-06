public class L_2579 {
    private static byte[] bytes;

    public static void main(String[] args) {
        System.out.println(coloredCells(1));
        System.out.println(coloredCells(2));
        System.out.println(coloredCells(3));
        System.out.println(coloredCells(4));
        System.out.println(coloredCells(5));
    }


    public static long coloredCells(int n) {
        long res = 1;
        long sum = 4;
        while (n > 1) {
            n--;
            res += sum;
            sum += 4;
        }
        return res;
    }
}
