import java.util.ArrayList;
import java.util.List;

public class L_141 {
    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    List<ListNode> ishlatildi = new ArrayList<>();

    public boolean hasCycle(ListNode head) {
        ishlatildi = new ArrayList<>();
        return hisobla(head);
    }

    private boolean hisobla(ListNode head) {
        if (ishlatildi.contains(head)) {
            return true;
        }
        ishlatildi.add(head);
        if (head.next == null) return false;
        return hisobla(head.next);
    }
}
/*

5
3 4 1 1 0 0

9
1 1 1 1 1 1 1 1 7 1

6
4 1 1 1 1 2 1

35

1 0 4 0 4 1 4 3 1 1 1 2 1 4 0 3 0 3 0 3 0 5 3 0 0 1 2 1 2 4 3 0 1 0 5 2
 */