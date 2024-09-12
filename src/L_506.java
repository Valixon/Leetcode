import java.util.Arrays;

public class L_506 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }


    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];
        String[] javob = new String[n + 1];
        for (int i = 4; i <= n; i++) {
            javob[i] = "" + i;
        }
        javob[1] = "Gold Medal";
        if (n > 1) javob[2] = "Silver Medal";
        if (n > 2) javob[3] = "Bronze Medal";
        int max = 1;
        for (int i : score) {
            max = Math.max(max, i);
        }
        int[] a = new int[max + 1];
        for (int i : score) {
            a[i] = 1;
        }
        int index = 1;
        for (int i = max; i >= 0; i--) {
            if (a[i] != 0) {
                a[i] = index;
                index++;
            }
        }
        for (int i = 0; i < n; i++) {
            res[i] = javob[a[score[i]]];
        }
        return res;
    }
}
