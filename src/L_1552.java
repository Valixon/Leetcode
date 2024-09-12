import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_1552 {

    private static List<List<Integer>> guruh = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{79, 74, 57, 22}, 4));
        System.out.println(maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
        System.out.println(maxDistance(new int[]{269826447, 974181916, 225871443, 189215924, 664652743, 592895362, 754562271, 335067223, 996014894, 510353008, 48640772, 228945137}, 3));
    }


    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        if (m == 2) return position[n - 1] - position[0];
        int st = 1;
        int en = position[n - 1];
        int md;
        while (st <= en) {
            md = (st + en) / 2;
            if (bolami(md, position, m-1)) {
                st = md + 1;
            } else
                en = md - 1;
        }
        return en;
    }

    private static boolean bolami(int md, int[] position, int m) {
        int index = 0;
        for (int i = 1; i < position.length; i++) {
            if (position[index] + md <= position[i]) {
                m--;
                index = i;
                if (m == 0) return true;
            }
        }
        if (m == 0) return true;
        return false;
    }
}