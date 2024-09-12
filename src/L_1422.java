public class L_1422 {
    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
        System.out.println(maxScore("00111"));
        System.out.println(maxScore("1111"));
        System.out.println(maxScore("0000"));
    }


    public static int maxScore(String s) {
        int n = s.length();
        int[] nollar = new int[n];
        int[] birlar = new int[n];
        if (s.charAt(0) == '0') {
            nollar[0] = 1;
        } else {
            birlar[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                nollar[i] = nollar[i - 1] + 1;
                birlar[i] = birlar[i - 1];

            } else {
                birlar[i] = birlar[i - 1] + 1;
                nollar[i] = nollar[i - 1];
            }
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(nollar[i] + birlar[n - 1] - birlar[i], max);
        }
        return max;
    }
}