import java.util.Arrays;

public class L_621 {
    public static void main(String[] args) {
        System.out.println((leastInterval(new char[]{'A', 'B', 'A'}, 2)));
//        System.out.println((leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)));
//        System.out.println((leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1)));
//        System.out.println((leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3)));

    }


    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] a = new int['Z' + 1];
        for (char i : tasks) {
            a[i]++;
        }
        Arrays.sort(a);
        int y = a['Z'];
        int p = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            if (a['Z'] == a[i]) p++;
        }
        return Math.max(tasks.length, (y - 1) * (n + 1) + p);
    }
}