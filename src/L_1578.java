public class L_1578 {

    public static void main(String[] args) {
        System.out.println(minCost("aaabbbabbbb", new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1}));
    }


    public static int minCost(String colors, int[] neededTime) {
        char[] color = colors.toCharArray();
        int sum = 0;
        char ch = color[0];
        int max1 = neededTime[0];
        for (int i = 1; i < color.length; i++) {
            char p = color[i];
            if (p == ch) {
                int n1 = neededTime[i];
                int max = Math.max(n1, max1);
                sum += Math.min(n1, max1);
                max1 = max;
            } else {
                max1 = neededTime[i];
            }
            ch = p;
        }
        return sum;
    }
}