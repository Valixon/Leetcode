import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L_1669 {

    private static int[] dp;

    public static void main(String[] args) {
//        System.out.println(rangeSumBST(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
//        System.out.println(numberOfArithmeticSlices2(new int[]{0, 1, 2, 2, 2}));
//        System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 4, 6, 8, 10}));
//        System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 4, 4, 6, 8, 10}));
//        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));
//        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7, 7}));
//        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7, 7, 7}));
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


    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        List<Integer> bir = new ArrayList<>();
        LinkedList<Integer> ikki = new LinkedList<>();
        int index = 0;
        while (list1 != null) {
            if (index < a || index > b) bir.add(list1.val);
            list1 = list1.next;
            index++;
        }
        while (list2 != null) {
            ikki.add(list2.val);
            list2 = list2.next;
        }
        bir.addAll(a, ikki);
        ListNode res = null;
        for (int i = bir.size() - 1; i >= 0; i--) {
            res = new ListNode(bir.get(i), res);
        }
        return res;
    }
}
