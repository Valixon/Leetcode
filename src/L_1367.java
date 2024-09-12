public class L_1367 {

    public static void main(String[] args) {
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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

    public boolean isSubPath(ListNode head, ListNode head2, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val == root.val) {
            if (isSubPath(head.next, head2, root.left) || isSubPath(head.next, head2, root.right)) return true;
        }
        if (!head.equals(head2)) return false;
        return isSubPath(head, head2, root.left) || isSubPath(head, head2, root.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        return isSubPath(head, head, root);
    }
}