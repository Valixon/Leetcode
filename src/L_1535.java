public class L_1535 {

    public static void main(String[] args) {
        System.out.println(getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
        System.out.println(getWinner(new int[]{3, 2, 1}, 10));
    }

    public static int getWinner(int[] arr, int k) {
        if (k == 1) return Math.max(arr[0], arr[1]);
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[0] > arr[i]) {
                res++;
                if (res == k) return arr[0];
            } else {
                arr[0] = arr[i];
                res = 1;
                if (res == k) return arr[0];
            }
        }
        return arr[0];
    }
}
