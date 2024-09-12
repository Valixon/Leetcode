import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestProblems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = 2752698;
        boolean tub[] = new boolean[n+1];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i; j <= n / i; j++) {
                tub[i * j] = true;
            }
        }
        List<Integer> tublar = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (!tub[i]) {
                tublar.add(i);
            }
        }
        int index = 1;
        List<Integer> utaTublar = new ArrayList<>();
        while (utaTublar.size() <= k) {
            while (tub[index]) {
                index++;
            }
            utaTublar.add(tublar.get(index));
            index++;
        }
        System.out.println(utaTublar.get(k));
    }
}
