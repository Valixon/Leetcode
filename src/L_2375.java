public class L_2375 {

    public static void main(String[] args) {
        System.out.println(smallestNumber("IIIDIDDD"));
        System.out.println(smallestNumber("DDD"));
    }


    public static String smallestNumber(String pattern) {
        String res = "";
        char[] w = pattern.toCharArray();
        int[] a = new int[pattern.length() + 1];
        int r = 1;
        for (int i = 0; i < w.length; i++) {
            if (w[i] == 'I') a[i++] = r++;
        }

        return res;

    }
}
