import java.util.PriorityQueue;

public class L_3066 {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2, 11, 10, 1, 3}, 10));
        System.out.println(minOperations(new int[]{1, 1, 2, 4, 9}, 20));
    }


    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        int cnt = 0;
        while (queue.isEmpty() || queue.peek() < k) {
            cnt++;
            long o = 2l * queue.poll() + queue.poll();
            if (o < k) queue.add((int) o);
        }
        return cnt;
    }
}
