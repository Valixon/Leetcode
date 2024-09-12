public class L_2181 {
    public static void main(String[] args) {
//        System.out.println(minDifference(new int[]{5, 3, 2, 4}));
//        System.out.println(minDifference(new int[]{1, 5, 0, 10, 14}));
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

    public ListNode mergeNodes(ListNode head) {
        return toldir(head.next);
    }

    private ListNode toldir(ListNode head) {
        if (head == null) return null;
        int sum = 0;
        while (head.val != 0) {
            sum += head.val;
            head = head.next;
        }
        head.val = sum;
        head.next = toldir(head.next);
        return head;
    }
}