import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class L_1845 {

    public static void main(String[] args) {
//        System.out.println(getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
//        System.out.println(getWinner(new int[]{3, 2, 1}, 10));
    }

    class SeatManager {
        private final HashSet<Integer> integers;
        public SeatManager(int n) {
            integers = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                integers.add(i);
            }
        }

        public int reserve() {
            int x = integers.stream().findFirst().get();
            integers.remove(x);
            return x;
        }

        public void unreserve(int seatNumber) {
            integers.add(seatNumber);
        }
    }
}
