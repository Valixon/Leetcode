import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L_1636 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(frequencySort(new int[]{2, 3, 1, 3, 2})));
        System.out.println(Arrays.toString(frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }

    static class Frequency {
        public int x;
        public int y;

        public Frequency(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static int[] frequencySort(int[] nums) {
        int[] p = new int[201];
        for (int num : nums) {
            p[num + 100]++;
        }
        List<Frequency> frequencies = new ArrayList<>();
        for (int i = 0; i < 201; i++) {
            if (p[i] == 0) continue;
            frequencies.add(new Frequency(i - 100, p[i]));
        }
        frequencies.sort(Comparator.comparingInt((Frequency o) -> o.y)
                .thenComparing((Frequency o1, Frequency o2) -> (o1.x - o2.x) * -1));

        int index = 0;
        for (Frequency frequency : frequencies) {
            for (int i = 1; i <= frequency.y; i++) {
                nums[index++] = frequency.x;
            }
        }
        return nums;
    }
}