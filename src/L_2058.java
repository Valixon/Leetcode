public class L_2058 {
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

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = new int[]{-1, -1};
        int left = head.val;
        head = head.next;
        int index = 0;
        int first = -100000;
        int last = -100000;
        int min = Integer.MAX_VALUE;
        while (head.next != null) {
            index++;
            if ((left < head.val && head.val > head.next.val) || (left > head.val && head.val < head.next.val)) {
                min = Math.min(min, index - last);
                last = index;
                if (first == -100000) first = index;
            }
            left = head.val;
            head = head.next;
        }
        if (first == last) return res;
        res[1] = last - first;
        res[0] = min;
        return res;
    }
}