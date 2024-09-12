import java.util.Arrays;

public class L_1457 {

    public static void main(String[] args) {
        String address = null;
        System.out.println(address.replaceAll("\\R|", " ").trim().replaceAll("\\s{2,}", " "));
    }

    public class TreeNode {
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

    private int res = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] a = new int[10];
        gaziniBos(root, a);
        return res;
    }

    private void gaziniBos(TreeNode root, int[] a) {
        a[root.val]++;
        if (root.left != null) {
            gaziniBos(root.left, a.clone());
        }
        if (root.right != null) {
            gaziniBos(root.right, a.clone());
        }
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (int i : a) {
                sum += (i % 2);
            }
            System.out.println(Arrays.toString(a));
            if (sum <= 1) {
                res++;
            }
        }
    }
}