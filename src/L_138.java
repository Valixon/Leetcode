import java.util.Scanner;

public class L_138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node node = new Node(7);
        Node node2 = new Node(13);
        node.next=node2;
        node2.random=node;
        Node node3 = new Node(11);
        node2.next=node3;
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        Node node6 = new Node(1);


        System.out.println(node);
        System.out.println(copyRandomList(node));
    }

    public static Node copyRandomList(Node head) {

        return head;
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
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