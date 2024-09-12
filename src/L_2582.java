public class L_2582 {
    public static void main(String[] args) {
        System.out.println(passThePillow(4, 5));
        System.out.println(passThePillow(3, 2));
    }

    public static int passThePillow(int n, int time) {
        return n - Math.abs(n - 1 - time % (n * 2 - 2));
    }
}