public class L_2914 {

    public static void main(String[] args) {
        System.out.println(minChanges("1001"));
        System.out.println(minChanges("10"));
    }


    public static int minChanges(String s) {
        int res = 0;
        byte[] a = s.getBytes();
        for (int i = 0; i < a.length; i += 2) {
            res += (a[i] + a[i + 1]) % 2;
        }
        return res;
    }
}