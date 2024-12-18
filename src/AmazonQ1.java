import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AmazonQ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(uniqueCoin(a));
    }
    private static List<Integer> uniqueCoin(int[] array) {
        List<Integer> unique = new ArrayList<>();
        for (Integer a : array) {
            if (unique.contains(a)) {
                unique.remove(a);
                a = a * 2;
                while (unique.contains(a)) {
                    unique.remove(a);
                    a = a * 2;
                }
                unique.add(a);
            } else {
                unique.add(a);
            }
        }
        return unique;
    }
}