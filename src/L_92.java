import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class L_92 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode h = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        System.out.println(reverseBetween(h, 2, 4));

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        List<Integer> list1 = new ArrayList<>(list.subList(0, left - 1));
        List<Integer> shallowCopy = new ArrayList<>(list.subList(left - 1, right));
        Collections.reverse(shallowCopy);
        list1.addAll(shallowCopy);
        list1.addAll(list.subList(right, list.size()));
        ListNode sw = new ListNode();
        sw.val = list1.get(list1.size() - 1);
        for (int j = list1.size() - 2; j >= 0; j--) {
            sw = new ListNode(list1.get(j), sw);

        }

        return sw;

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