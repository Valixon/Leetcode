public class L_2265 {
    public static int sum;

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
        System.out.println(averageOfSubtree(x));
    }

    public static int averageOfSubtree(TreeNode root) {
        halla(root);
        return sum;
    }

    public static int[] halla(TreeNode root) {
        int[] a = new int[2];
        if (root == null) {
            return a;
        }
        a[0] = root.val;
        a[1]++;
        int[] left = halla(root.left);
        int[] right = halla(root.right);
        a[0] += left[0];
        a[1] += left[1];
        a[0] += right[0];
        a[1] += right[1];
        if (a[0] / a[1] == root.val) {
            sum++;
        }
        return a;
    }
}
