import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L_1382 {
    private static List<Integer> hammasi;

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
        System.out.println(balanceBST(po));
        System.out.println(balanceBST(xx));
    }


    public static TreeNode balanceBST(TreeNode root) {
        hammasi = new ArrayList<>();
        salom(root);
        Collections.sort(hammasi);
        return hisobla(0, hammasi.size());
    }

    private static TreeNode hisobla(int left, int right) {
        int size = (right + left) / 2;
        if (right == left) return null;
        int val = hammasi.get(size);
        return new TreeNode(val, hisobla(left, size), hisobla(size, right));
    }

    private static void salom(TreeNode root) {
        if (root == null) return;
        hammasi.add(root.val);
        salom(root.left);
        salom(root.right);
    }
}