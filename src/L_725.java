import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L_725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode h = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        System.out.println(Arrays.toString(splitListToParts(h, 3)));

    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] a = new ListNode[k];
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int x = list.size() / k;
        int y = list.size() % k;
        for (int i = 1; i <= k; i++) {
            int r = 0;
            if (y > 0) {
                y--;
                r = 1;
            }
            List<Integer> list1 = list.subList(0, x + r);
            list = list.subList(x + r, list.size());
            ListNode sw = new ListNode();
            if (list1.size() == 0) {
                break;
            }
            sw.val = list1.get(list1.size() - 1);
            for (int j = list1.size() - 2; j >= 0; j--) {
                sw = new ListNode(list1.get(j), sw);

            }
            a[i - 1] = sw;
        }
        return a;
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

}