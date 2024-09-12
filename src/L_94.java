import java.util.ArrayList;
import java.util.List;

public class L_94 {

    public static ArrayList<Integer> res;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(inorderTraversal(node));
        TreeNode node2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, null, new TreeNode(6)));
        System.out.println(inorderTraversal(node2));
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
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        if (root == null)
        olayBoqqingni(root);
        return res;
    }

    public static void olayBoqqingni(TreeNode root) {
        if (root.left != null) {
            olayBoqqingni(root.left);
        }
        res.add(root.val);
        if (root.right != null) {
            olayBoqqingni(root.right);
        }
    }
}