import java.util.List;

public class L_624 {
    public static void main(String[] args) {

    }

    public static int maxDistance(List<List<Integer>> arrays) {
        int minIndex1 = 0;
        int maxIndex1 = 0;
        int min1 = 0;
        int min2 = 0;
        int max1 = 0;
        int max2 = 0;
        int index = 0;
        for (List<Integer> array : arrays) {
            int min = 0;
            int max = 0;
            if (min <= min1) {
                min2 = min1;
                min1 = min;
                minIndex1 = index;
            } else if (min < min2) {
                min2 = min;
            }
            if (max > max1) {
                max2 = max1;
                max1 = max;
                maxIndex1 = index;
            } else if (max > max2) {
                max2 = max;
            }
            index++;
        }
        System.out.println(minIndex1 + " " + maxIndex1);
        if (minIndex1 != maxIndex1) {
            return max1 - min1;
        }
        return Math.max(max2 - min1, max1 - min2);
    }
}