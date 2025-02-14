public class L_1352 {


    private int[] a;
    private int index;

    public ProductOfNumbers() {
        a = new int[40001];
        index = 0;

    }

    public void add(int num) {
        a[index++] = num;
    }

    public int getProduct(int k) {
        int sum = 1;
        for (int i = 1; i <= k; i++) {
            sum *= a[index - i];
            if (sum == 0) return sum;
        }
        return sum;
    }
}
