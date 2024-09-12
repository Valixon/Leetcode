import java.util.ArrayList;
import java.util.List;

public class L_1609 {

    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(isEvenOddTree(new TreeNode(1)));
//        System.out.println(rangeSumBST(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
//        System.out.println(numberOfArithmeticSlices2(new int[]{0, 1, 2, 2, 2}));
//        System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 4, 6, 8, 10}));
//        System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 4, 4, 6, 8, 10}));
//        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));
//        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7, 7}));
//        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer>[] a = new List[10001];

    public static boolean isEvenOddTree(TreeNode root) {
        a = new List[10001];
        hisobla(0, root);
        for (int i = 0; i <= 100000; i++) {
            if (a[i] == null) break;
            if (i % 2 == 0 && !toqOsuvchi(a[i])) {
                return false;
            }
            if (i % 2 == 1 && !juftKamayuvchi(a[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean toqOsuvchi(List<Integer> integers) {
        int birinchi = integers.get(0);
        if (birinchi % 2 == 0) return false;
        for (int i = 1; i < integers.size(); i++) {
            int q = integers.get(i);
            if (q <= birinchi || q % 2 == 0) return false;
            birinchi = q;
        }
        return true;
    }

    private static boolean juftKamayuvchi(List<Integer> integers) {
        int birinchi = integers.get(0);
        if (birinchi % 2 == 1) return false;
        for (int i = 1; i < integers.size(); i++) {
            int q = integers.get(i);
            if (q >= birinchi || q % 2 == 1) return false;
            birinchi = q;
        }
        return true;
    }

    private static void hisobla(int index, TreeNode root) {
        if (root == null) return;
        if (a[index] == null) {
            a[index] = new ArrayList<>();
        }
        a[index].add(root.val);
        index++;
        hisobla(index, root.left);
        hisobla(index, root.right);
    }
}
