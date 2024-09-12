public class L_2807 {
    public static void main(String[] args) {
        System.out.println(insertGreatestCommonDivisors(new ListNode(18, new ListNode(6, new ListNode(10, new ListNode(3))))));
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode next = head;
        while (next.next != null) {
            int gcd = gcd(next.val, next.next.val);
            next.next = new ListNode(gcd, next.next);
            next = next.next.next;
        }
        return head;
    }

    public static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) a %= b;
            else b %= a;
        }
        return a + b;
    }
}