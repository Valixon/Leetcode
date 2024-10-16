import java.util.PriorityQueue;

public class L_1405 {
    public static void main(String[] args) {
        System.out.println(longestDiverseString(1, 1, 7));
        System.out.println(longestDiverseString(7, 1, 0));
    }


    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        PriorityQueue<Salom> queue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        if (a > 0) queue.add(new Salom('a', a));
        if (b > 0) queue.add(new Salom('b', b));
        if (c > 0) queue.add(new Salom('c', c));
        while (!queue.isEmpty()) {
            Salom p = queue.poll();
            char o = p.value;
            if (res.toString().endsWith(o + "" + o)) {
                if (queue.isEmpty()) return res.toString();
                Salom p2 = queue.poll();
                res.append(p2.value);
                p2.count--;
                if (p2.count != 0) {
                    queue.add(p2);
                }
                queue.add(p);
            } else {
                res.append(o);
                p.count--;
                if (p.count != 0) {
                    queue.add(p);
                }
            }
        }
        return res.toString();
    }

    static class Salom {
        char value;
        int count;

        public Salom(char value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
