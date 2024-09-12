public class L_129 {
    public static void main(String[] args) {
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

    public static int sumNumbers(TreeNode root) {
        return hisobla(root, 0);
    }

    private static int hisobla(TreeNode root, int sum) {
        if (root == null) return sum;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        if (root.left == null) {
            return hisobla(root.right, sum);
        }
        if (root.right == null) {
            return hisobla(root.left, sum);
        }
        return hisobla(root.left, sum) + hisobla(root.right, sum);
    }
}
