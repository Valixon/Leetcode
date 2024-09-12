
public class L_1758 {
    public static void main(String[] args) {
        System.out.println(minOperations("0100"));
        System.out.println(minOperations("10"));
        System.out.println(minOperations("1111"));
    }


    public static int minOperations(String s) {
        int max1 = 0, max2 = 0, cur1 = 0, cur2 = 1;
        for (int i = 0; i < s.length(); i++) {
            int p = s.charAt(i) - 48;
            if (p != cur1) {
                max1++;
            } else {
                max2++;
            }
            cur1++;
            cur1 %= 2;
        }
        return Math.min(max1, max2);
    }
}