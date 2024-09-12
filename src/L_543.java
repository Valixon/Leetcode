import java.util.TreeSet;

public class L_543 {

    private static int[] dp;

    public static void main(String[] args) {
//        System.out.println(rangeSumBST(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
//        System.out.println(numberOfArithmeticSlices2(new int[]{0, 1, 2, 2, 2}));
//        System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 4, 6, 8, 10}));
//        System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 4, 4, 6, 8, 10}));
//        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));
//        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7, 7}));
//        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7, 7, 7}));
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

    public static TreeSet<Integer> s1 = new TreeSet<>();

    public static int diameterOfBinaryTree(TreeNode root) {
        s1 = new TreeSet<>();
        hisobla(root);
        return s1.last();
    }

    private static int hisobla(TreeNode root) {
        if (root == null) return 0;
        int left = hisobla(root.left);
        left++;
        int right = hisobla(root.right);
        right++;
        s1.add(left + right);
        return Math.max(left, right);
    }
}
