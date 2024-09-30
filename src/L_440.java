import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_440 {
    public static void main(String[] args) {
        System.out.println(findKthNumber(13, 2));
        System.out.println(findKthNumber(1, 1));
        System.out.println(findKthNumber(1, 1));
        System.out.println(findKthNumber(100, 9));
        System.out.println(findKthNumber(3564, 5));
    }

    static class TrieNode {
        TrieNode[] children;
        int index;
        int value;

        TrieNode(int value, int index) {
            this.value = value;
            children = new TrieNode[10];
            this.index = index;
        }
    }
    public static int findKthNumber(int n, int k) {
        TrieNode root = new TrieNode(1,1);
        while (root.value < n && root.index < k){

        }
        return 1;
    }

    public static int findKthNumber3(int n, int k) {
        if (n < 10) return k;
        return findKthNumber2(n, k);
    }

    public static int findKthNumber2(int n, int k) {
        if (n < 10) return k - 1;
        int[] a = new int[10];
        for (int i = 1; i <= 9; i++) {
            a[i] = 1;
            int y = i;
            int p = 1;
            while (y * 10 + (p * 10) - 1 <= n) {
                p *= 10;
                y *= 10;
                a[i] += p;
            }
            System.out.println(n % (y)+" "+ p);
            if (n % (y * 10) < p * 10) {
                a[i] += (n % (y * 10) + 1);
            }
        }
        System.out.println(n + " " + k + " " + Arrays.toString(a));
        for (int i = 1; i <= 9; i++) {
            if (a[i] <= k) {
                k = k - a[i];
            } else {

            }

        }
        return 1;
    }

    public static List<Integer> lexicalOrder(int n) {
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = "" + (i + 1);
        }
        Arrays.sort(a);
        List<Integer> res = new ArrayList<>();
        for (String i : a)
            res.add(Integer.parseInt(i));
        return res;
    }
}