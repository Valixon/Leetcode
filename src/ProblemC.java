import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Coordination[] a = new Coordination[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Coordination(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(a, new Comparator<Coordination>() {
            @Override
            public int compare(Coordination o1, Coordination o2) {
                return o1.x1 - o2.x1;
            }
        });
        boolean po[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < Math.min(n, i + 10); j++) {
                if (a[i].x1 >= a[j].x1 && a[i].x2 <= a[j].x2 || a[i].x1 <= a[j].x1 && a[i].x2 >= a[j].x2) {
                    po[i] = true;
                    po[j] = true;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!po[i]) res++;
        }
        System.out.println(res);
    }
}

class Coordination {
    int x1, x2;

    public Coordination(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}