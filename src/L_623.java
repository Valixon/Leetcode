public class L_623 {
    public static void main(String[] args) {
        TreeNode r = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), new TreeNode(6, new TreeNode(5), null));
        System.out.println(addOneRow(r, 1, 2));
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        depth--;
        if (depth == 0) {
            return new TreeNode(val, root, null);
        }
        if (root == null) return null;
        if (depth == 1) {
            TreeNode chap = null;
            TreeNode ong = null;
            chap = new TreeNode(val, root.left, null);
            ong = new TreeNode(val, null, root.right);
            return new TreeNode(root.val, chap, ong);
        }
        return new TreeNode(root.val, addOneRow(root.left, val, depth), addOneRow(root.right, val, depth));
    }
}
