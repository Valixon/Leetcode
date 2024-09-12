import java.util.Random;

public class L_1296 {

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(isNStraightHand(new int[]{1, 1, 2, 2, 3, 3}, 2));
    }


    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        if (groupSize == 1) return true;
        Random random = new Random();
        return random.nextBoolean();
    }
}