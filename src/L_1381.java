public class L_1381 {
    public static void main(String[] args) {
    }


    static class CustomStack {
        int[] a;
        int index;

        public CustomStack(int maxSize) {
            a = new int[maxSize];
            index = 0;

        }

        public void push(int x) {
            if (index < a.length) {
                a[index] = x;
                index++;
            }
        }

        public int pop() {
            if (index == 0) return -1;
            index--;
            return a[index + 1];
        }

        public void increment(int k, int val) {
            for (int i = 0; i < Math.min(a.length, k); i++) {
                a[i] += val;
            }
        }
    }
}
