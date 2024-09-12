import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MasalaD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> a = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            a.add(sc.nextInt());
        }
        if (a.size() < 4) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
