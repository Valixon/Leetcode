import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L_77 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        int data[] = new int[k];
        combinationUtil(a, data, 0, n - 1, 0, k, result);
        return result;

    }

    public static void combinationUtil(Integer[] arr, int[] data, int start, int end, int index, int k, List<List<Integer>> result) {
        if (index == k) {
            List<Integer> res = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                res.add(data[j]);
            }
            result.add(res);
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= k - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, k, result);
        }
    }

}
