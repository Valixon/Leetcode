import java.util.LinkedList;

public class L_1823 {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(6, 5));
    }

    public static int findTheWinner(int n, int k) {
        LinkedList<Integer> salom = new LinkedList<>();
        int start = k - 1;
        for (int i = 1; i <= n; i++) {
            if (i % k == 0) {
                start = salom.size();
                continue;
            }
            salom.add(i);
        }
        k--;
        start = (start + k) % salom.size();
        while (salom.size() > 1) {
            salom.remove(start);
            start = (start + k) % salom.size();
        }
        return salom.get(0);
    }
}