public class L_1208 {

    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3));
        System.out.println(equalSubstring("abcd", "cdef", 3));
        System.out.println(equalSubstring("abcd", "acde", 0));
        System.out.println(equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14));
    }


    public static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] a = new int[n + 1];
        char[] ch = s.toCharArray(), target = t.toCharArray();
        for (int i = 0; i < n; i++) {
            a[i] = Math.abs(ch[i] - target[i]);
        }
        a[n] = 1000000;
        int max = 0;
        int startIndex = 0;
        int sum = 0;
        for (int i = startIndex; i <= n; i++) {
            if (sum + a[i] > maxCost) {
                max = Math.max(max, i - startIndex);
                i--;
                sum -= a[startIndex];
                startIndex++;
            } else {
                sum += a[i];
            }
        }
        return max;
    }
}