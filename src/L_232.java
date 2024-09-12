import java.util.LinkedList;

public class L_232 {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.peek();
        System.out.println(param_2);
        int param_3 = obj.pop();
        System.out.println(param_3);

        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
    public  static  class MyQueue {

        public LinkedList<Integer> list;

        public MyQueue() {
            list = new LinkedList<>();
        }

        public void push(int x) {
            list.add(x);
        }

        public int pop() {
            int x = list.getFirst();
            list.removeFirst();
            return x;
        }

        public int peek() {
            return list.getFirst();
        }

        public boolean empty() {
            return list.isEmpty();
        }
    }
}




