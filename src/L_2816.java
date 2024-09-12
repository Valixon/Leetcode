public class L_2816 {
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

    public static ListNode doubleIt(ListNode head) {
        int x = yooddagi(head);
        if (x != 0) {
            return new ListNode(x, head);
        }
        return head;
    }

    private static int yooddagi(ListNode head) {
        int val = head.val;
        val *= 2;
        int yodda = 0;
        if (head.next != null) {
            yodda = yooddagi(head.next);
        }
        val += yodda;
        head.val = val % 10;
        return val/10;
    }
}
