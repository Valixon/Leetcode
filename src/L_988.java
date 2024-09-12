public class L_988 {

    public static void main(String[] args) {
        System.out.println((int) 'a');
        TreeNode r = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), new TreeNode(6, new TreeNode(5), null));
//        System.out.println(addOneRow(r, 1, 2));
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

    private String min;

    public String smallestFromLeaf(TreeNode root) {
        String b = "";
        min = "";
        ataboyevich(root, b);
        return min;
    }

    private void ataboyevich(TreeNode root, String b) {
        if (root == null) return;
        b = (char) (root.val + 97) + "" + b;
        if (root.left == null && root.right == null) {
            if (min.isEmpty() && min.compareTo(b) > 0) {
                min = b;
            }
            return;
        }
        if (!min.isEmpty() && min.compareTo(b) < 0) return;
        ataboyevich(root.left, b);
        ataboyevich(root.right, b);
    }
}
