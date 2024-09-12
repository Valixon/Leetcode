import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L_1282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(groupThePeople(a));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> javob = new ArrayList<>();

        List<Integer>[] a = new List[groupSizes.length+1];



        Arrays.fill(a, new ArrayList<Integer>());

        for (int i = 0; i < groupSizes.length; i++) {
            int x = groupSizes[i];
            a[x].add(i);
        }
        for (int x = 1; x < a.length; x++) {
            List<Integer> list2 = a[x];
            for (int i = 1; i <= list2.size() / x; i++) {
                javob.add(list2.subList((i - 1) * x, i * x));
            }
        }
        return javob;
    }
}
/*

5
3 4 1 1 0 0

9
1 1 1 1 1 1 1 1 7 1

6
4 1 1 1 1 2 1

35

1 0 4 0 4 1 4 3 1 1 1 2 1 4 0 3 0 3 0 3 0 5 3 0 0 1 2 1 2 4 3 0 1 0 5 2

7
3 3 3 3 3 1 3
 */

