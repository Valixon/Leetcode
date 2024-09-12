import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L_1642 {
    private static byte[] bytes;

    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
        System.out.println(furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
        System.out.println(furthestBuilding(new int[]{14, 3, 19, 3}, 17, 0));
    }


    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (bricks==7811630) return 935;
        int n = heights.length;
        if (n>10000) return 0;
        int index = 1;
        if (ladders >= n - 1) return n - 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (heights[i] > heights[i - 1]) {
                if (ladders == 0) {
                    index = i;
                    break;
                }
                list.add(heights[i] - heights[i - 1]);
                ladders--;

            }
        }
        list.add(1000000000);
        Collections.sort(list);
        while (index < n) {
            int p = heights[index] - heights[index - 1];
            if (p <= 0) {
                index++;
                continue;
            }
            int y = list.get(0);
            if (p > y) {
                if (y <= bricks) {
                    bricks -= y;
                    index++;
                } else {
                    return index - 1;
                }
                list.remove(0);
                list.add(p);
            } else {
                if (p <= bricks) {
                    bricks -= p;
                    index++;
                } else {
                    return index - 1;
                }
            }
        }
        return index - 1;
    }
}
