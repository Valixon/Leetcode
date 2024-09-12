import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L_2751 {
    public static void main(String[] args) {
        System.out.println(survivedRobotsHealths(new int[]{5, 4, 3, 2, 1}, new int[]{2, 17, 9, 15, 10}, "RRRRR"));
        System.out.println(survivedRobotsHealths(new int[]{3, 5, 2, 6}, new int[]{10, 10, 15, 12}, "RLRL"));
        System.out.println(survivedRobotsHealths(new int[]{1, 2, 5, 6}, new int[]{10, 10, 11, 11}, "RLRL"));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> res = new ArrayList<>();
        int n = directions.length();
        byte[] bytes = directions.getBytes();
        Jumanazar[] a = new Jumanazar[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Jumanazar(positions[i], healths[i], bytes[i] == 'R', i);
        }
        Arrays.sort(a, (o1, o2) -> o1.position - o2.position);
        LinkedList<Jumanazar> salom = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (salom.isEmpty()) {
                salom.add(a[i]);
                continue;
            }
            if (salom.getLast().direction && !a[i].direction) {
                if (salom.getLast().health == a[i].health) {
                    salom.removeLast();
                } else if (salom.getLast().health > a[i].health) {
                    salom.getLast().health--;
                } else {
                    salom.removeLast();
                    a[i].health--;
                    i--;
                }
            } else {
                salom.add(a[i]);
            }
        }

        salom.sort((o1, o2) -> o1.index - o2.index);
        for (Jumanazar jumanazar : salom) {
            res.add(jumanazar.health);
        }

        return res;
    }

    static class Jumanazar {
        public int position;
        public int health;
        public boolean direction;
        public int index;

        public Jumanazar(int position, int health, boolean direction, int index) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
    }
}