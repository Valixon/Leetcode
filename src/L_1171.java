import java.util.ArrayList;
import java.util.List;

public class L_1171 {
    public static void main(String[] args) {
//        System.out.println(customSortString("cba","abcd"));
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

    public ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> a = new ArrayList<>();
        while (head != null) {
            a.add(head.val);
            head = head.next;
        }
        int[] num = new int[a.size()];
        int index = 0;
        for (Integer i : a) {
            num[index++] = i;
        }
        int indexi = 0;
        int indexj = 0;
        for (int i = 0; i < num.length; i++) {
            int sum = num[i];
            indexj = 0;
            for (int j = i + 1; j < num.length; j++) {
                sum += num[j];
                if (sum == 0) {
                    indexj = j;
                }
            }
            if (indexj > 0) {
                for (int j = i; j <= indexj; j++) {
                    a.set(j, 1001);
                }
                System.out.println(a);
                i = indexj;
            }
        }
        int[] num2 = new int[a.size()];
        int index2 = 0;
        for (Integer i : a) {
            num2[index2++] = i;
        }
        ListNode res = new ListNode();
        for (int i = num2.length - 1; i >= 0; i--) {
            if (num2[i] == 1001) continue;
            res = new ListNode(num2[i], res);
        }
        return res;
    }
}