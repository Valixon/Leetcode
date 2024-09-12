public class L_2487 {
    public static void main(String[] args) {
    }

    public static class ListNode {
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

    public static ListNode removeNodes(ListNode head) {
        while (head.next != null) {
            if (head.val < head.next.val) {
                head.val = head.next.val;
                head.next = head.next.next;
            }
        }
        return head;
    }
}
