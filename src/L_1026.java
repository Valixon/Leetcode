public class L_1026 {


    public static void main(String[] args) {
//        System.out.println(rangeSumBST(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
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

    public Integer salom = 0;

    public int maxAncestorDiff(TreeNode root) {
        salom = 0;
        int max = 0;
        max = hisobla(root.val, root, max);
        return max;
    }

    private int hisobla(int value, TreeNode root, int max) {
        int ms = Math.abs(root.val - value);
        if (max < ms) {
            max = ms;
            salom = root.val - value;
        }
        if (root.left == null && root.right == null) return max;
        if (root.right == null) {
            int q = hisobla(value, root.left, max);
            max = Math.max(max, q);
            if (salom > 0 && value > root.val) {
                max = max + (value - root.val);
            } else if (salom < 0 && value < root.val) {
                max = max + (root.val - value);
            }
            return max;
        }
        if (root.left == null) {
            return Math.max(max, Math.max(hisobla(value, root.right, max), hisobla(root.right.val, root.right, max)));
        }
        return Math.max(max, Math.max(Math.max(hisobla(value, root.left, max), hisobla(root.left.val, root.left, max)), Math.max(hisobla(value, root.right, max), hisobla(root.right.val, root.right, max))));
    }

}
