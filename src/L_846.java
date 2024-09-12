import java.util.Arrays;

public class L_846 {

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(isNStraightHand(new int[]{1, 1, 2, 2, 3, 3}, 2));
    }


    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        if (groupSize == 1) return true;
        Arrays.sort(hand);
        int count = 1;
        int index = 0;
        int index2 = 0;
        while (index < hand.length) {
            index2 = index;
            for (int i = index + 1; i < hand.length; i++) {
                if (hand[i] == hand[index] + 1) {
                    count++;
                    hand[index] = -1;
                    index = i;
                } else if (hand[i] > hand[index] + 1) {
                    return false;
                }
                if (count == groupSize) {
                    count = 1;
                    hand[index] = -1;
                    index = hand.length;
                    for (int j = index2; j < hand.length; j++) {
                        if (hand[j] != -1) {
                            index = j;
                            break;
                        }
                    }
                    break;
                }
                if (i == hand.length - 1) return false;
            }
        }
        return true;
    }
}