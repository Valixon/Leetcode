public class L_2938 {
    public static void main(String[] args) {
    }


    public static long minimumSteps(String s) {
        byte[] a = s.getBytes();
        long sum = 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (a[i] == 1) {
                sum += count;
            } else {
                count++;
            }
        }
        return sum;
    }
}
