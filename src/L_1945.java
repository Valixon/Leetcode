public class L_1945 {

    public static void main(String[] args) {
        System.out.println((int) '1');
        System.out.println(getLucky("iiii", 1));
        System.out.println(getLucky("leetcode", 2));
        System.out.println(getLucky("zbax", 2));
    }


    public static int getLucky(String s, int k) {
        String sum = "";
        for (char i : s.toCharArray()) {
            sum = sum + "" + (i - 96);
        }
        while (k > 0) {
            k--;
            sum = getSumcha(sum);
        }
        return Integer.parseInt(sum);
    }

    private static String getSumcha(String sum) {
        int y = 0;
        for (char i : sum.toCharArray()) {
            y += (i - 48);
        }
        return y + "";
    }

}