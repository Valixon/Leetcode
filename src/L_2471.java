import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class L_2471 {

    public static void main(String[] args) {
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

    private List<Integer>[] a;
    private TreeSet<Integer>[] b;

    public int minimumOperations(TreeNode root) {
        a = new List[1000];
        b = new TreeSet[1000];
        korqani(root, 0);
        int res = 0;
        for (int i = 1; i < 1000; i++) {
            if (a[i] == null) break;
            int j = 0;
            Integer[] aa = a[i].toArray(Integer[]::new);
            for (int y : b[i]) {
                if (aa[j] != y) {
                    int index = -1;
                    for (int op = 0; op < aa.length; op++) {
                        if (aa[op] == y) {
                            index = op;
                            break;
                        }
                    }
                    aa[index] = aa[j];
                    res++;
                }
                j++;
            }
        }
        return res;
    }

    private void korqani(TreeNode root, int i) {
        if (root == null) return;
        if (a[i] == null) {
            a[i] = new ArrayList<>();
            b[i] = new TreeSet<>();
        }
        a[i].add(root.val);
        b[i].add(root.val);
        korqani(root.left, i + 1);
        korqani(root.right, i + 1);
    }
}