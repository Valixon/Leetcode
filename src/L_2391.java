public class L_2391 {
    public static void main(String[] args) {
        System.out.println(garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));
        System.out.println(garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10}));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int countM = 0, sumM = 0;
        int countP = 0, sumP = 0;
        int countG = 0, sumG = 0;
        int sum = 0;
        int i = 0;
        int[] count = new int['P' + 1];
        while (i < n - 1) {
            String s = garbage[i];
            for (char ch : s.toCharArray())
                count[ch]++;
            int count_m = count['M'];
            int count_g = count['G'];
            int count_p = count['P'];
            if (count_m != 0) {
                countM += count_m;
                sumM = countM + sum;
                count['M'] = 0;
            }
            if (count_g != 0) {
                countG += count_g;
                sumG = countG + sum;
                count['G'] = 0;
            }
            if (count_p != 0) {
                countP += count_p;
                sumP = countP + sum;
                count['P'] = 0;
            }
            sum += travel[i];
            i++;
        }
        String s = garbage[i];
        for (char ch : s.toCharArray())
            count[ch]++;
        int count_m = count['M'];
        int count_g = count['G'];
        int count_p = count['P'];
        if (count_m != 0) {
            countM += count_m;
            sumM = countM + sum;
        }
        if (count_g != 0) {
            countG += count_g;
            sumG = countG + sum;
        }
        if (count_p != 0) {
            countP += count_p;
            sumP = countP + sum;
        }
        return sumG + sumM + sumP;
    }
}