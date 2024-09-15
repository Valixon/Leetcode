public class L_1371 {
    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(findTheLongestSubstring("bcbcbc"));
    }

    public static int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] a = new int[n + 1];
        int[] e = new int[n + 1];
        int[] i = new int[n + 1];
        int[] o = new int[n + 1];
        int[] u = new int[n + 1];
        switch (s.charAt(0)) {
            case 'a' -> a[1] = 1;
            case 'e' -> e[1] = 1;
            case 'i' -> i[1] = 1;
            case 'o' -> o[1] = 1;
            case 'u' -> u[1] = 1;
        }
        for (int j = 2; j <= n; j++) {
            char l = s.charAt(j - 1);
            a[j] = a[j - 1];
            e[j] = e[j - 1];
            i[j] = i[j - 1];
            o[j] = o[j - 1];
            u[j] = u[j - 1];
            if (l == 'a') {
                a[j] = a[j - 1] + 1;
            } else if (l == 'e') {
                e[j] = e[j - 1] + 1;
            } else if (l == 'i') {
                i[j] = i[j - 1] + 1;
            } else if (l == 'o') {
                o[j] = o[j - 1] + 1;
            } else if (l == 'u') {
                u[j] = u[j - 1] + 1;
            }
        }
        for (int j = n - 1; j > 1; j--) {
            for (int k = 1; k <=n - j; k++) {
                if ((a[k + j] - a[k-1]) % 2 == 0
                        && (e[k + j] - e[k-1]) % 2 == 0
                        && (i[k + j] - i[k-1]) % 2 == 0
                        && (o[k + j] - o[k-1]) % 2 == 0
                        && (u[k + j] - u[k-1]) % 2 == 0) {
                    return j + 1;
                }
            }
        }
        return 1;
    }
}