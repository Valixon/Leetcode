public class L_2196 {
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
        System.out.println(createBinaryTree(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}}));
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode[] a = new TreeNode[100001];
        boolean[] childmi = new boolean[100001];
        TreeNode op;
        TreeNode p;
        for (int[] description : descriptions) {
            int x = description[0];
            int y = description[1];
            int z = description[2];
            childmi[y] = true;
            if (a[y] != null) {
                p = a[y];
            } else {
                p = new TreeNode(y);
            }
            if (a[x] != null) {
                op = a[x];
            } else {
                op = new TreeNode(x);
            }
            if (z == 1) {
                op.left = p;
            } else {
                op.right = p;
            }
            a[x] = op;
            a[y] = p;
        }
        for (int[] description : descriptions) {
            if (childmi[description[0]]) return a[description[0]];
        }
        return new TreeNode();
    }
}