import java.util.PriorityQueue;

public class L_2530 {
    public static void main(String[] args) {
        System.out.println(maxKelements(new int[]{10, 10, 10, 10, 10}, 5));
        System.out.println(maxKelements(new int[]{1, 10, 3, 3, 3}, 3));
    }


    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> op = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) op.add(num);
        long sum = 0;
        while (k > 0) {
            k--;
            int y = op.poll();
            sum += y;
            y = (y + 2) / 3;
            op.add(y);
        }
        return sum;
    }
}
