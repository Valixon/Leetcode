import java.time.ZonedDateTime;

public class L_3217 {

    public static void main(String[] args) {
        ZonedDateTime las = ZonedDateTime.now().minusMinutes(3);
        if (las.compareTo(ZonedDateTime.now().minusMinutes(5)) < 0) {
            System.out.println("ishladi");
        }
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

    public ListNode modifiedList(int[] nums, ListNode head) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        boolean[] x = new boolean[max + 1];
        for (int num : nums) {
            x[num] = true;
        }
        return modifiedList(x, head);
    }

    private ListNode modifiedList(boolean[] nums, ListNode head) {
        if (head == null) return null;
        if (head.val < nums.length && nums[head.val]) {
            return modifiedList(nums, head.next);
        }
        head.next = modifiedList(nums, head.next);
        return head;
    }
}