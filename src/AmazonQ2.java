import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class AmazonQ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(maxInventory(a));
    }

    private static Long maxInventory(int[] array) {
        int n = array.length;

        TreeSet<Integer> ishlatildi = new TreeSet<>();
        TreeSet<Integer> ishlatilmadi = new TreeSet<>();
        int toq = 0;
        if (n % 2 == 1) {
            toq = 1;
            ishlatildi.add(array[n / 2]);
        }
        int start = n / 2;
        for (int i = 0; i < n / 2; i++) {
            int left = start - i - 1;
            int right = start + i + toq;
            if (!ishlatildi.contains(array[left])) {
                ishlatilmadi.add(array[left]);
            }
            if (!ishlatildi.contains(array[right])) {
                ishlatilmadi.add(array[right]);
            }
            if (ishlatilmadi.isEmpty()) continue;
            ishlatildi.add(ishlatilmadi.pollLast());
        }
        long sum = 0;
        for (Integer i : ishlatildi)
            sum += i;
        return sum;
    }
}