import java.util.Random;

public class L_1460 {

    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        Random r = new Random();
        return r.nextBoolean();
    }
}
