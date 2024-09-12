import java.util.ArrayList;
import java.util.List;

public class L_225 {
    public static void main(String[] args) {

    }

    class MyStack {
        List<Integer> a;

        public MyStack() {
            a = new ArrayList<>();
        }

        public void push(int x) {
            a.add(x);
        }

        public int pop() {
            int x = a.get(a.size() - 1);
            a.remove(a.size() - 1);
            return x;
        }

        public int top() {
            int x = a.get(a.size() - 1);
            return x;
        }

        public boolean empty() {
            return a.isEmpty();
        }
    }
}
