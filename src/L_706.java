public class L_706 {

    class MyHashMap {
        int[] a = new int[1000001];

        public MyHashMap() {
            for (int i = 0; i < 1000001; i++) {
                a[i] = Integer.MIN_VALUE;
            }
        }

        public void put(int key, int value) {
            a[key] = value;
        }

        public int get(int key) {
            return Math.max(a[key], -1);
        }

        public void remove(int key) {
            a[key] = Integer.MIN_VALUE;
        }
    }

}
