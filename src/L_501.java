import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class L_501 {
    public static int[] a;
    public static int max;

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

    public static void main(String[] args) {
        TreeNode x = new TreeNode(1);
        System.out.println(Arrays.toString(findMode(x)));
    }

    public static int[] findMode(TreeNode root) {
        a = new int[200005];
        max = 0;
        halla(root);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 200005; i++) {
            if (a[i] == max) {
                numbers.add(i - 100000);
            }
        }
        int[] res = new int[numbers.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = numbers.get(i);
        }
        return res;
    }

    private static void halla(TreeNode root) {
        a[root.val + 100000]++;
        max = Math.max(max, a[root.val + 100000]);
        if (root.left != null) {
            halla(root.left);
        }
        if (root.right != null) {
            halla(root.right);
        }
    }
}
