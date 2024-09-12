public class L_979 {
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

    public int count = 0;

    public int distributeCoins(TreeNode root) {
        count = 0;
        hisobla(root);
        return count;
    }

    private int hisobla(TreeNode root) {
        if (root.left != null) {
            root.val = root.val + hisobla(root.left);
        }
        if (root.right != null) {
            root.val = root.val + hisobla(root.right);
        }
        count += Math.abs(1 - root.val);
        return root.val-1;
    }
}