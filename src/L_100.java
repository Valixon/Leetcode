import java.util.ArrayList;

public class L_100 {

    private static ArrayList<String> mozzi1;
    private static ArrayList<String> mozzi2;

    public static void main(String[] args) {
//        System.out.println(isSameTree(6, new int[][]{{1, 2, 5}, {2, 3, 8}, {1, 5, 10}}, 1));
//        System.out.println(findAllPeople(4, new int[][]{{3, 1, 3}, {1, 2, 2}, {0, 3, 3}}, 3));
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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        mozzi1 = new ArrayList<>();
        mozzi2 = new ArrayList<>();
        coll(p);
        coll2(q);
        System.out.println(mozzi1);
        System.out.println(mozzi2);
        return mozzi1.equals(mozzi2);

    }

    private static void coll(TreeNode p) {
        if (p == null) {
            mozzi1.add("null");
        }
        mozzi1.add(p.val + "");
        coll(p.left);
        coll(p.right);
    }

    private static void coll2(TreeNode p) {
        if (p == null) {
            mozzi2.add("null");
        }
        mozzi2.add(p.val + "");
        coll2(p.left);
        coll2(p.right);
    }
}
