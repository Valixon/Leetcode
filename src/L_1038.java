public class L_1038 {
    private static int val = 0;

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

    public static void main(String[] args) {
        TreeNode po = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))),
                new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
        TreeNode xx = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4));
        System.out.println(bstToGst(po));
        System.out.println(bstToGst(xx));
    }


    public static TreeNode bstToGst(TreeNode root) {
        val = 0;
        salom(root);
        return root;
    }

    private static void salom(TreeNode root) {
        if (root == null) return;
        salom(root.right);
        root.val += val;
        val = root.val;
        salom(root.left);
    }
}