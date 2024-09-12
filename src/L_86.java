import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L_86 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n];
        ListNode listNode = new ListNode();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        listNode = new ListNode(a[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            listNode = new ListNode(a[i], listNode);
        }
        System.out.println(partition(listNode, p));
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        List<Integer> a1 = new ArrayList<>();
        List<Integer> b1 = new ArrayList<>();
        while (head != null) {
            int p = head.val;
            if (p < x) {
                a1.add(p);
            } else {
                b1.add(p);
            }
            head = head.next;
        }
        a1.addAll(b1);
        ListNode listNode = new ListNode(a1.get(a1.size() - 1));
        for (int i = a1.size() - 2; i >= 0; i--) {
            listNode = new ListNode(a1.get(i), listNode);
        }
        return listNode;

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
//[1, 2, 2, 1, 2, 2, 2, 3, 4, 5, 6, 7, 4, 3, 5]
//[1, 2, 2, 1, 2, 2, 2, 3, 4, 5, 6, 7, 4, 3, 5]