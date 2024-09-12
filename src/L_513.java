public class L_513 {

    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(a[0]!=null);
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

    public static String[] a = new String[10001];

    public static int findBottomLeftValue(TreeNode root) {
        a = new String[10001];

        hisobla(0, root);
        for (int i = 10000; i >= 0; i--) {
            if (a[i] != null) {
                System.out.println(a[i]);
                return Integer.parseInt(a[i]);
            }
        }
        return root.val;
    }

    private static void hisobla(int index, TreeNode root) {
        if (root == null) return;
        index++;
        if (root.left != null) {
            a[index] = root.left.val + "";
        }
        hisobla(index, root.left);
        hisobla(index, root.right);
    }
}
