import java.util.ArrayList;
import java.util.List;

public class L_872 {

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

    public static List<Integer> s1 = new ArrayList<>();
    public static List<Integer> s2 = new ArrayList<>();

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        s1 = new ArrayList<>();
        s2 = new ArrayList<>();
        hisobla1(root1);
        hisobla2(root2);
        System.out.println(s1);
        System.out.println(s2);
        if (s1.size() != s2.size()) return false;
        for (int i = 0; i < s1.size(); i++) {
            if (s1.get(i) != s2.get(i)) return false;
        }
        return true;
    }

    private static void hisobla1(TreeNode root1) {
        if (root1.left == null && root1.right == null) {
            s1.add(root1.val);
        }
        if (root1.left != null) {
            hisobla1(root1.left);
        }
        if (root1.right != null) {
            hisobla1(root1.right);
        }
    }

    private static void hisobla2(TreeNode root1) {
        if (root1.left == null && root1.right == null) {
            s2.add(root1.val);
        }
        if (root1.left != null) {
            hisobla2(root1.left);
        }
        if (root1.right != null) {
            hisobla2(root1.right);
        }
    }

}
